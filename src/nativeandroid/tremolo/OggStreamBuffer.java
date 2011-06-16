package nativeandroid.tremolo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import nativeandroid.stdio.jnaerated.stdioLibrary;
import nativeandroid.tremolo.jnaerated.jnaeratedLibrary;
import nativeandroid.tremolo.jnaerated.ov_callbacks;
import nativeandroid.tremolo.jnaerated.OggVorbis_File;
import nativeandroid.tremolo.jnaerated.vorbis_comment;
import nativeandroid.tremolo.jnaerated.vorbis_info;

import org.bridj.*;

class VorbisException extends Exception
{
	public VorbisException ()
	{
		this ("Vorbis exception");
	}

	public VorbisException (String message)
	{
		super (message);
	}

	public VorbisException (String message, Exception innerException)
	{
		super (message, innerException);
	}

	public VorbisException (int errorCode)
	{
		this (String.format ("Vorbis exception error code %d", errorCode));
	}
}

public class OggStreamBuffer
{
	class ov_read extends ov_callbacks.read_func_callback
	{
		@Override
		public long apply(Pointer<?> ptr, long size, long nmemb, Pointer<?> datasource)
		{
			if (buffer == null || buffer.length < size * nmemb)
				buffer = new byte [(int) (size * nmemb)];
			try {
				int actual = stream.read (buffer, 0, buffer.length);
				if (actual < 0)
					return 0;//throw new VorbisException (String.Format ("Stream of type {0} returned a negative number: {1}", stream.GetType () , (int) actual) );
				ptr.setBytes(ByteBuffer.wrap(buffer, 0, actual));
				return actual;
			} catch (IOException ex) {
				return 0;
			}
		}
	}
	class ov_seek extends ov_callbacks.seek_func_callback
	{
		@Override
		public int apply(Pointer<?> datasource, long offset, int whence) {
			try {
				if (whence == 0)
					stream.seek(-stream.getFilePointer() + offset);
				else if (whence == 1)
					stream.seek (offset);
				else
					stream.seek(stream.length() + offset);
				return 0;
			} catch (IOException ex) {
				return -1;
			}
		}
		
	}
	class ov_close extends ov_callbacks.close_func_callback
	{

		@Override
		public int apply(Pointer<?> datasource) {
			try {
				stream.close ();
				return 0;
			} catch (IOException ex) {
				return -1;
			}
		}
	}
	class ov_tell extends ov_callbacks.tell_func_callback
	{
		@Override
		public long apply(Pointer<?> datasource) {
			try {
				return (long) stream.getFilePointer();
			} catch (IOException ex) {
				return -1;
			}
		}
	}

	public OggStreamBuffer (String path)
	{
		this (path, Charset.defaultCharset());
	}

	public OggStreamBuffer (String path, Charset textEncoding)
	{
		text_encoding = textEncoding;
		jnaeratedLibrary.ov_open(stdioLibrary.fopen(Pointer.pointerToCString(path), Pointer.pointerToCString("r")), Pointer.pointerTo(vorbis_file), Pointer.NULL, 0);
		//OvMarshal.ov_open (OvMarshal.fopen (path, "r") , Pointer.pointerTo(vorbis_file), null, 0);
		//handle_ovf = GCHandle.Alloc (vorbis_file, GCHandleType.Pinned);
		callbacks = vorbis_file.callbacks();
	}

	public OggStreamBuffer (RandomAccessFile stream)
	{
		this (stream, Charset.defaultCharset());
	}

	public OggStreamBuffer (RandomAccessFile stream, Charset textEncoding)
	{
		this.stream = stream;
		text_encoding = textEncoding;
		callbacks = new ov_callbacks ();
		callbacks.read_func(new ov_read ().toPointer());
		callbacks.seek_func(new ov_seek ().toPointer());
		callbacks.close_func(new ov_close ().toPointer());
		callbacks.tell_func(new ov_tell ().toPointer());
		vorbis_file = new OggVorbis_File ();
		// first vfp is a dummy datasource.
		jnaeratedLibrary.ov_open_callbacks(vfp(), vfp(), null, 0, callbacks);
		//handle_ovf = GCHandle.Alloc (vorbis_file, GCHandleType.Pinned);
	}

	RandomAccessFile stream;

	//GCHandle handle_ovf;
	Charset text_encoding;
	ov_callbacks callbacks;
	OggVorbis_File vorbis_file;
	Long bitrate_instant, streams;
	Boolean seekable;
	int current_bit_stream;
	byte [] buffer;

	Pointer<OggVorbis_File> vfp ()
	{
		return Pointer.pointerTo (vorbis_file); //handle_ovf.AddrOfPinnedObject (); }
	}

	OggVorbis_File getVorbisFile ()
	{
		return vorbis_file;
	}

	public int getCurrentBitStream ()
	{ return current_bit_stream; }

	public long getBitrateInstant() 
	{
		if (bitrate_instant == null)
			bitrate_instant = OvMarshal.ov_bitrate_instant (vfp());
		return (long) bitrate_instant;
	}

	public long getStreams ()
	{
		if (streams == null)
			streams = OvMarshal.ov_streams (vfp());
		return (long) streams;
	}

	public boolean Seekable ()
	{
		if (seekable == null)
			seekable = OvMarshal.ov_seekable (vfp()) != 0;
		return (boolean) seekable;
	}

	protected void finalize()
	{
		OvMarshal.ov_clear (vfp());
		//if (handle_ovf.IsAllocated)
		//	handle_ovf.Free ();
	}

	public int getBitrate (int i)
	{
		long ret = OvMarshal.ov_bitrate (vfp(), i);
		return (int) ret;
	}

	public int getSerialNumber (int i)
	{
		long ret = OvMarshal.ov_serialnumber (vfp(), i);
		return (int) ret;
	}

	public OggVorbisInfo getInfo (int i)
	{
		Pointer<vorbis_info> ret = OvMarshal.ov_info (vfp(), i);
		return new OggVorbisInfo (ret.get());
	}

	public OggVorbisComment getComment (int link)
	{
		Pointer<vorbis_comment> ret = OvMarshal.ov_comment (vfp(), link);
		return new OggVorbisComment (ret.get(), text_encoding);
	}

	public long getTotalRaw (int i)
	{
		long ret = OvMarshal.ov_raw_total (vfp(), i);
		return ret;
	}

	public long getTotalPcm (int i)
	{
		long ret = OvMarshal.ov_pcm_total (vfp(), i);
		return ret;
	}

	public long getTotalTime (int i)
	{
		long ret = OvMarshal.ov_time_total (vfp(), i);
		return ret;
	}

	public int seekRaw (long pos)
	{
		int ret = OvMarshal.ov_raw_seek (vfp(), pos);
		return ret;
	}

	public int seekPcm (long pos)
	{
		int ret = OvMarshal.ov_pcm_seek (vfp(), pos);
		return ret;
	}

	public int seekTime (long pos)
	{
		int ret = OvMarshal.ov_time_seek (vfp(), pos);
		return ret;
	}

	public long tellRaw ()
	{
		long ret = OvMarshal.ov_raw_tell (vfp());
		return ret;
	}

	public long tellPcm ()
	{
		long ret = OvMarshal.ov_pcm_tell (vfp());
		return ret;
	}

	public long tellTime ()
	{
		long ret = OvMarshal.ov_time_tell (vfp());
		return ret;
	}

	/*
	public long read (short [] buffer, int index, int length)
	{

		return Read (buffer, index, length, ref current_bit_stream);
	}

	public long read (short [] buffer, int index, int length, Pointer<Integer> bitStream)
	{
		long ret = 0;
		//unsafe
		//{
			//fixed (short* bufptr = buffer)
				ret = OvMarshal.ov_read (vfp, (Pointer<Integer>) (bufptr + index) , length / 2, ref bitStream);
		//}
		return ret / 2;
	}
	*/
	
	Pointer<Byte> read_buf;
	int buf_length;

	public long read (byte [] buffer, int index, int length)
	{
		Pointer<Integer> p = Pointer.pointerToInt(current_bit_stream);
		long ret = read (buffer, index, length, p);
		current_bit_stream = p.get();
		return ret;
	}

	public long read (byte [] buffer, int index, int length, Pointer<Integer> bitStream)
	{
		if (buf_length < length)
			read_buf = Pointer.allocateBytes(length);
		long ret = OvMarshal.ov_read (vfp (), read_buf, length, bitStream);
		read_buf.getByteBuffer(ret).get(buffer, index, (int) ret);
		return ret;
	}
}


