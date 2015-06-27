package name.atsushieno.falplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import name.atsushieno.falplayer.R;
import nativeandroid.dirent.DirectoryEntry;

import nativeandroid.dirent.DirectoryIterator;
import nativeandroid.unistd.jnaerated.unistdLibrary;

import org.apache.commons.io.IOUtils;
import org.bridj.Pointer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class FalplayerActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		org.bridj.AndroidWorkaround.setApplication(getApplication());

		title_database = new TitleDatabase(this);
		player = new Player(title_database, this);
	}

	Player player;
	TitleDatabase title_database;

	void createSongDirectoryList() {
		SharedPreferences sp = this.getSharedPreferences("falplayer",
				Context.MODE_PRIVATE);
		List<String> list = new Vector();
		getOggDirectories("/", list);
		// getOggDirectories (new File ("/"), list);
		StringBuilder sb = new StringBuilder();
		for (String dir : list) {
			sb.append(dir);
			sb.append('\n');
		}
		Editor ed = sp.edit();
		ed.putString("songdirs.txt", sb.toString());
		ed.commit();
	}

	void getOggDirectories(File dir, List<String> list) {
		boolean hasOgg = false;
		String abs = dir.getAbsolutePath();
		if (abs.equals("/proc") || abs.equals("/sys") || abs.equals(("/data")))
			return;
		File[] fl = dir.listFiles();
		if (fl == null)
			return;
		for (File f : fl) {
			if (f.isDirectory()) {
				f = f.getAbsoluteFile();
				getOggDirectories(f, list);
			}
			if (!hasOgg) {
				if (f.getName().toLowerCase().endsWith(".ogg")) {
					hasOgg = true;
					list.add(dir.getAbsolutePath());
				}
			}
		}
	}

	void getOggDirectories(String path, List<String> list) {
		if (unistdLibrary.access(Pointer.pointerToCString(path),
				unistdLibrary.X_OK | unistdLibrary.R_OK) != 0)
			return;
		if (path.equals("/proc") || path.equals("/sys") || path.equals("/data"))
			return;
		DirectoryIterator di = new DirectoryIterator(path);
		boolean hasOgg = false;
		do {
			DirectoryEntry de = di.next();
			if (de == null)
				break;
			if (de.getEntryType() == DirectoryIterator.ENTRY_TYPE_DIR) {
				String dn = de.getName();
				if (!dn.equals(".") && !dn.equals(".."))
					getOggDirectories((path.equals("/") ? "" : path).concat(
							File.separator).concat(dn), list);
			}
			if (!hasOgg && de.getName().toLowerCase().endsWith(".ogg")) {
				hasOgg = true;
				list.add(path);
			}
		} while (true);
	}
}

class PlayerView implements SeekBar.OnSeekBarChangeListener {
	public interface FileSelectionAction {
		void run(File file);
	}

	final String from_history_tag = "<from history>";
	Player player;
	TitleDatabase database;
	FalplayerActivity activity;
	Button load_button, play_button, stop_button, rescan_button;
	TextView title_text_view, timeline_text_view;
	SeekBar seekbar;
	long loop_start, loop_length, loop_end, total_length;
	Date total_time;
	int loops;
	SharedPreferences preferences;

	public PlayerView(Player player, TitleDatabase database,
			FalplayerActivity activity) {
		date_format = new SimpleDateFormat ("mm:ss.SSS");

		this.player = player;
		this.database = database;
		this.activity = activity;
		this.load_button = (Button) activity.findViewById(R.id.SelectButton);
		this.play_button = (Button) activity.findViewById(R.id.PlayButton);
		this.stop_button = (Button) activity.findViewById(R.id.StopButton);
		this.rescan_button = (Button) activity.findViewById(R.id.RescanButton);
		this.seekbar = (SeekBar) activity.findViewById(R.id.SongSeekbar);
		this.title_text_view = (TextView) activity
				.findViewById(R.id.SongTitleTextView);
		this.timeline_text_view = (TextView) activity
				.findViewById(R.id.TimelineTextView);
		setPlayerEnabled(false);

		preferences = activity.getSharedPreferences("falplayer",
				Context.MODE_PRIVATE);
		if (preferences.getString("songdirs.txt", null) == null)
			load_button.setEnabled(false);

		load_button.setOnClickListener(new LoadClickListener());

		play_button.setOnClickListener(new PlayClickListener());

		stop_button.setOnClickListener(new StopClickListener());

		rescan_button.setOnClickListener(new RescanClickListener());
	}

	class RescanDialogOKClickLisnter implements DialogInterface.OnClickListener {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			createSongDirectoryList();
			load_button.setEnabled(true);
		}
	}

	class RescanClickListener implements Button.OnClickListener {
		@Override
		public void onClick(View view) {
			AlertDialog.Builder db = new AlertDialog.Builder(activity);
			db
					.setMessage("Scan music directories. This operation takes a while.");
			db.setPositiveButton("OK", new RescanDialogOKClickLisnter());
			db.setCancelable(true);
			db.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
			db.show();
		}
	}

	class PlayClickListener implements Button.OnClickListener {
		@Override
		public void onClick(View view) {
			try {
				if (player.isPlaying()) {
					player.pause();
				} else {
					player.play();
				}
			} catch (Exception ex) {
				play_button.setText(ex.getMessage());
			}
		}
	}

	class StopClickListener implements Button.OnClickListener {
		@Override
		public void onClick(View view) {
			player.stop();
		}
	}

	class LoadClickListener implements Button.OnClickListener {
		public void onClick(View view) {
			AlertDialog.Builder db = new AlertDialog.Builder(activity);
			db.setTitle("Select Music Folder");

			List<String> dirlist = new Vector<String>();
			if (preferences.getString("history.txt", null) != null)
				dirlist.add(from_history_tag);
			try {
				for (String s : IOUtils.readLines(new StringReader(preferences
						.getString("songdirs.txt", ""))))
					if (s != null && s.length() > 0)
						dirlist.add(s);
			} catch (IOException ex) { // should not happen
			}
			String[] dirs = new String[dirlist.size()];
			dirlist.toArray(dirs);

			db.setItems(dirs, new FileDialogOKClickListener(dirs));
			db.show();
		}
	}

	class FileDialogOKClickListener implements DialogInterface.OnClickListener {
		String[] dirs;

		public FileDialogOKClickListener(String[] dirs) {
			this.dirs = dirs;
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			String dir = dirs[which];
			processFileSelectionDialog(dir, new FileSelectionAction() {
				@Override
				public void run(File mus) {
					player.selectFile(mus);
					player.play();
				}
			});
		}
	}

	void createSongDirectoryList() {
		boolean wasPlaying = player.isPlaying();
		if (wasPlaying)
			player.pause();
		load_button.setEnabled(false);
		this.title_text_view.setText("scanning directory...hold on");
		activity.createSongDirectoryList();
		this.title_text_view.setText("");
		load_button.setEnabled(true);
		if (wasPlaying)
			player.play();
	}

	void setPlayState() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				play_button.setText("Pause");
			}
		});
	}

	void setPauseState() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				play_button.setText("Play");
			}
		});
	}

	FilenameFilter ogg_filter = new FilenameFilter() {
		public boolean accept(File file, String filename) {
			return filename.toLowerCase().endsWith(".ogg");
		}
	};

	void processFileSelectionDialog(String dir, FileSelectionAction action) {
		List<File> l = new Vector<File>();
		if (dir == from_history_tag) {
			for (String s : player.getPlayHistory())
				l.add(new File(s));
		} else {
			File d = new File(dir);
			if (d.exists()) {
				File[] list = d.listFiles(ogg_filter);
				Arrays.sort(list, new Comparator<File>() {
					public int compare(File f1, File f2) {
						return f1.getName().compareTo(f2.getName());
					}
				});
				for (File file : list)
					l.add(file);
			}
		}
		AlertDialog.Builder db = new AlertDialog.Builder(activity);
		if (l.size() == 0)
			db.setMessage("No music files there");
		else {
			db.setTitle("Select Music File");
			List<String> files = new Vector<String>();
			for (File f : l) {
				String title = database.getTitle(f.getName(), f.length());
				files.add(title != null ? title : f.getName());
			}
			String[] arr = new String[files.size()];
			files.toArray(arr);
			db.setItems(arr, new FileSelectorDialogClickListener(l, files,
					action));
		}
		db.show().show();
	}

	class FileSelectorDialogClickListener implements
			DialogInterface.OnClickListener {
		List<File> files;
		List<String> titles;
		FileSelectionAction action;

		public FileSelectorDialogClickListener(List<File> files,
				List<String> titles, FileSelectionAction action) {
			this.files = files;
			this.titles = titles;
			this.action = action;
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			int idx = which;
			title_text_view.setText(titles.get(idx));
			action.run(files.get(idx));
		}
	}

	public void initialize(long totalLength, long loopStart, long loopLength,
			long loopEnd, long totalTime) {
		loops = 0;
		loop_start = loopStart;
		loop_length = loopLength;
		loop_end = loopEnd;
		total_length = totalLength;
		total_time = new Date(totalTime);
		setPlayerEnabled(true);
		reset();
	}

	class PlayerRunnable implements Runnable {
		public PlayerRunnable(PlayerView pv) {
			this.pv = pv;
		}

		PlayerView pv;

		@Override
		public void run() {
			play_button.setText("Play");
			timeline_text_view.setText(getTimeline(0, 0));
			// Since our AudioTrack bitrate is fake, those markers must be faked
			// too.
			seekbar.setMax((int) total_length);
			seekbar.setProgress(0);
			seekbar.setSecondaryProgress((int) loop_end);
			seekbar.setOnSeekBarChangeListener(pv);
		}
	}

	public void reset() {
		activity.runOnUiThread(new PlayerRunnable(this));
	}

	boolean player_enabled;

	public boolean getPlayerEnabled() {
		return play_button.isEnabled();
	}

	class SetPlayerEnabledRunnable implements Runnable {
		boolean value;

		public SetPlayerEnabledRunnable(boolean value) {
			this.value = value;
		}

		@Override
		public void run() {
			play_button.setEnabled(value);
			stop_button.setEnabled(value);
			seekbar.setEnabled(value);
		}
	}

	public void setPlayerEnabled(boolean value) {
		activity.runOnUiThread(new SetPlayerEnabledRunnable(value));
	}

	class OnErrorRunnable implements Runnable {
		String msgbase;
		Object[] args;

		public OnErrorRunnable(String msgbase, Object[] args) {
			this.msgbase = msgbase;
			this.args = args;
		}

		@Override
		public void run() {
			setPlayerEnabled(false);
			play_button.setText(String.format(msgbase, args));
		}
	}

	public void error(String msgbase, Object... args) {
		activity.runOnUiThread(new OnErrorRunnable(msgbase, args));
	}

	DateFormat date_format;

	String getTimeline(long pos, long playTime) {
		Date pt = new Date(playTime);
		return String.format("loop: %d / cur: %d / end: %d\ntime: %s / %s",
				loops, pos, loop_end, date_format.format(pt.getTime() - pt.getDate()),
				date_format.format(total_time.getTime() - total_time.getDate()));
	}

	class ReportProgressRunnable implements Runnable {
		public ReportProgressRunnable(long pos, long time) {
			this.pos = pos;
			this.time = time;
		}

		long pos;
		long time;

		public void run() {
			timeline_text_view.setText(getTimeline(pos, time));
			seekbar.setProgress((int) pos);
		}
	}

	public void reportProgress(long pos, long time) {
		activity.runOnUiThread(new ReportProgressRunnable(pos, time));
	}

	public void processLoop(long resetPosition) {
		loops++;
		seekbar.setProgress((int) resetPosition);
	}

	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (!fromUser)
			return;
		player.seek(progress);
	}

	public void onStartTrackingTouch(SeekBar seekBar) {
		// do nothing
	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		// do nothing
	}
}
