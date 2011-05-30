package name.atsushieno.falplayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.*;

public class Player
{
    static final int CompressionRate = 2;

    Activity activity;
    PlayerView view;
    OggStreamBuffer vorbis_buffer;
    LoopCommentExtension loop;
    CorePlayer task;
    long start_time;
    SharedPreferences preferences;

    public Player (TitleDatabase database, MainActivity activity)
    {
        initialize (database, activity);
    }

    void initialize (TitleDatabase database, MainActivity activity)
    {
        this.activity = activity;
        view = new PlayerView (this, database, activity);
        task = new CorePlayer (this);
        headset_status_receiver = new HeadphoneStatusReceiver (this);
        preferences = activity.getSharedPreferences("falplayer", Context.MODE_PRIVATE);
    }

    List<String> getPlayHistory ()
    {
        List<String> l = new Vector<String>();
        String hist = preferences.getString ("history.txt", null); 
        if (hist != null)
            for (String file : IOUtils.readLines (new StringReader(hist)))
                if (file != null && file.length() > 0)
                    l.add(file);
        return l;
    }

    public void selectFile (File file)
    {
    	List<String> hist = getPlayHistory ();
    	String abspath = file.getAbsolutePath();
    	if (!hist.contains (abspath)) {
    		Context ctx = activity.getApplicationContext();
    		SharedPreferences sp = ctx.getSharedPreferences ("falplayer", Context.MODE_PRIVATE);
    		List<String> allhist = IOUtils.readLines(new StringReader (sp.getString("history.txt", "")));
    		Editor ed = sp.edit();
    		ed.remove("history.txt");
    		StringBuilder sb = new StringBuilder ();
    		sb.append(abspath);
    		sb.append('\n');
    		for (String item : allhist)
    			if (!item.equals (abspath)) {
    				sb.append (item);
    				sb.append ('\n');
    			}
    		ed.putString("history.txt", sb.toString());
        }

        InputStream input = new FileInputStream (file);
        vorbis_buffer = new OggStreamBuffer (input);
        loop = new LoopCommentExtension (vorbis_buffer);
        initializeVorbisBuffer ();
    }

    public void initializeVorbisBuffer ()
    {
        view.initialize (loop.getTotal () * 4, loop.getStart () * 4, loop.getLength () * 4, loop.getEnd ()* 4, vorbis_buffer.getTotalTime (-1));
        task.LoadVorbisBuffer (vorbis_buffer, loop);
    }

    public LoopCommentExtension getLoop ()
    {
        return loop;
    }

    public boolean isPlaying ()
    {
        return task.status == PlayerStatus.Playing;
    }

    HeadphoneStatusReceiver headset_status_receiver;

    public void play ()
    {
        if (task.getStatus () == PlayerStatus.Paused)
            task.resume ();
        else {
            stop ();
            //SpinWait.SpinUntil(() => task.Status == PlayerStatus.Stopped);
            //if (task != null)
            //    task.dispose ()
            task = new CorePlayer (this);
            initializeVorbisBuffer ();
            start_time = new Date ().getTime ();
            task.start ();
        }
        view.setPlayState ();
        activity.registerReceiver (headset_status_receiver, new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY));
    }

    public void pause ()
    {
        task.pause ();
        view.setPauseState ();
    }

    public void stop ()
    {
        task.stop ();
    }

    public void seek (long pos)
    {
        task.seek (pos);
    }

    void onComplete ()
    {
        view.reset ();
    }

    void onPlayerError (String msgbase, Object... args)
    {
        view.error (msgbase, args);
    }

    void onProgress (long pos)
    {
        view.reportProgress (pos, new Date().getTime() - start_time);
    }

    void onLoop (long resetPosition)
    {
        view.processLoop (resetPosition);
    }


    class PlayerStatus
    {
        public final static int Stopped = 0;
        public final static int Playing = 1;
        public final static int Paused = 2;
    }

    class CorePlayer implements Runnable
    {
    	static final int CompressionRate = Player.CompressionRate; 
        static final int min_buf_size = AudioTrack.getMinBufferSize (44100 / CompressionRate * 2, AudioFormat.CHANNEL_CONFIGURATION_STEREO, AudioFormat.ENCODING_PCM_16BIT);
        int buf_size = min_buf_size * 8;

        AudioTrack audio;
        Player player;
        boolean pause, finish;
        Object pause_handle = new Object ();
        int x;
        byte [] buffer;
        long loop_start, loop_length, loop_end, total;
        Thread player_thread;

        public CorePlayer (Player player)
        {
            this.player = player;
            // "* n" part is adjusted for device.
            audio = new AudioTrack (AudioManager.STREAM_MUSIC, 44100 / CompressionRate * 2, AudioFormat.CHANNEL_CONFIGURATION_STEREO, AudioFormat.ENCODING_PCM_16BIT, buf_size * 4, AudioTrack.MODE_STREAM);
            // FIXME: when I set to "bufsize / 2 / CompressionRate" with CompressionRate = 2, AudioTrack.Write() blocks for some songs...
            buffer = new byte [buf_size / 4 / CompressionRate];
            player_thread = new Thread (this);
        }

        int status;
        public int getStatus ()
        {
        	return status;
        }

        public void loadVorbisBuffer (OggStreamBuffer ovb, LoopCommentExtension loop)
        {
            loop_start = loop.getStart () * 4;
            loop_length = loop.getLength () * 4;
            loop_end = loop.getEnd () * 4;
            total = loop.getTotal ();
        }

        public void pause ()
        {
            status = PlayerStatus.Paused;
            pause = true;
        }

        public void resume ()
        {
            status = PlayerStatus.Playing;
            pause = false; // make sure to not get overwritten
            pause_handle.notify ();
        }

        long last_seek;

        public void seek (long pos)
        {
            if (pos < 0 || pos >= loop_end) 
                return; // ignore
            long now = new Date ().getTime();
            if (now - last_seek < 500)
                return; // too short seek operations
            last_seek = now;
            //SpinWait.SpinUntil (() => !pause);
            player.vorbis_buffer.seekPcm (pos / 4);
            total = pos;
        }

        public void stop ()
        {
            finish = true; // and let player loop finish.
            pause_handle.notify ();
        }

        public void start ()
        {
            if (status != PlayerStatus.Stopped) {
                stop ();
                //SpinWait.SpinUntil (() => Status == PlayerStatus.Stopped);
            }
            player_thread.start ();
        }

    	@Override
    	public void run ()
    	{
    		player.vorbis_buffer.seekRaw (0);
    		status = PlayerStatus.Playing;
    		x = 0;
    		total = 0;
    	
    		audio.play ();
    		while (!finish)
    		{
    		if (pause) {
    		    pause = false;
    		    audio.pause ();
    		    pause_handle.wait();
    		    audio.play ();
    		}
    		long size = player.vorbis_buffer.read (buffer, 0, buffer.length);
    		if (size <= 0 || size > buffer.length) {
    		    finish = true;
    		    if (size < 0)
    		        player.onPlayerError ("vorbis error : {0}", size);
    			else if (size > buffer.length)
    			    player.onPlayerError ("buffer overflow : {0}", size);
    			break;
    		}
    	
    		if (size + total >= loop_end)
    		    size = loop_end - total; // cut down the buffer after loop
    		total += size;
    		
    		if (++x % 30 == 0)
    		    player.onProgress (total);
    		
    		// downgrade bitrate
    		int actualSize = (int) size * 2 / CompressionRate;
    		for (int i = 1; i < actualSize; i++)
    		    buffer [i] = buffer [i * CompressionRate / 2 + (CompressionRate / 2) - 1];
    		if (size > 0) {
    		    audio.flush ();
    		    audio.write (buffer, 0, actualSize);
    		}
    		// loop back to LOOPSTART
    		if (total >= loop_end) {
    		    player.vorbis_buffer.seekPcm (loop_start / 4); // also faked
    		        player.onLoop (loop_start);
    		        total = loop_start;
    		    }
    		}
    		audio.flush ();
    		audio.stop ();
    		player.onComplete ();
    		status = PlayerStatus.Stopped;
    	}
    		
    	protected void finalize ()
    	{
    		 if (audio.getPlayState () != AudioTrack.PLAYSTATE_STOPPED)
    		     audio.stop ();
    		 audio.release ();
    	}
    }

    class HeadphoneStatusReceiver extends BroadcastReceiver
    {
    	Player player;
    	public HeadphoneStatusReceiver (Player player)
    	{
    		this.player = player;
    	}
    	
    	@Override
    	public void onReceive (Context context, Intent intent)
    	{
    		if (intent.getAction () == AudioManager.ACTION_AUDIO_BECOMING_NOISY)
    			player.pause ();
    	}
    }
}

class LoopCommentExtension
{
    long loop_start = 0, loop_length = Integer.MAX_VALUE, loop_end = Integer.MAX_VALUE, total;

    public LoopCommentExtension (OggStreamBuffer owner)
    {
    total = owner.GetTotalPcm (-1);
    for (OggVorbisComment cmt : owner.GetComment(-1).Comments)
    {
    String comment = cmt.replace(" ", ""); // trim spaces
    if (comment.startsWith("LOOPSTART="))
    loop_start = Integer.parseInt (comment.substring("LOOPSTART=".length ()));
    if (comment.startsWith("LOOPLENGTH="))
    loop_length = Integer.parseInt (comment.substring("LOOPLENGTH=".length ()));
    }

    if (loop_start > 0 && loop_length > 0)
    loop_end = (loop_start + loop_length);
    }

    public long getStart()
    {
    return loop_start;
    }

    public long getLength ()
    {
    return loop_length;
    }

    public long getEnd ()
    {
    return loop_end;
    }

    public long getTotal ()
    {
    return total;
    }
}

class TitleDatabase
{
    public class SongData
    {
	    public SongData (String line)
	    {
		    String [] items = line.split("w");
		    fileName = items [0];
		    fileSize = Integer.parseInt (items [1]);
		    title = line.substring (items [0].length () + 1 + items [1].length ()).trim ();
	    }

	    public String fileName;
	    public long fileSize;
	    public String title;
    }

    List<SongData> list;

    public TitleDatabase (MainActivity activity)
    {
	    list = new Vector<SongData> ();
	    try {
		    for (String ass : activity.getAssets ().list ("titles")) {
			    InputStream stream = activity.getAssets ().open ("titles/" + ass);
			    for (String line : IOUtils.readLines(stream))
			    if (line != null && line.length ()> 0 && !line.startsWith ("//"))
			    list.add (new SongData (line));
		    }
	    } catch (IOException ex) {
	    	android.util.Log.e("falplayer", "failed to read application asset 'titles'");
	    	list = new Vector<SongData> (); // dummy empty list
	    }
    }

    public String getTitle (String filename, long fileSize)
    {
	    String fn = new File (filename).getName ();
	    for (SongData t : list)
	    	if (t.fileName.equals(fn) && t.fileSize == fileSize)
	    		return t.title;
	    return null;
    }
}
