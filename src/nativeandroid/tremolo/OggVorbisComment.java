package nativeandroid.tremolo;

import org.bridj.*;
import org.bridj.Pointer.StringType;

import java.nio.charset.Charset;
import nativeandroid.tremolo.jnaerated.vorbis_comment;

public class OggVorbisComment
{
	final vorbis_comment c;
	final Charset text_encoding;

	OggVorbisComment (vorbis_comment c, Charset textEncoding)
	{
		this.c = c;
		text_encoding = textEncoding;
	}

	/*
	public OggVorbisComment (Pointer<Integer> ptr, Charset textEncoding)
	{
		c = (vorbis_comment) Marshal.PtrToStructure (ptr, typeof (VorbisComment) );
		text_encoding = textEncoding;
	}
	*/

	public String [] getComments ()
	{
		String [] ret = new String [c.comments()];
		for (int i = 0; i < ret.length; i++)
			//unsafe
			{
				Pointer<Pointer<Byte>> cptr = c.user_comments();
				Pointer<Byte> ptr = cptr.get(i);
				int len = c.comment_lengths().get(i);
				ret [i] = text_encoding.decode(ptr.getByteBuffer(len)).toString();
			}
		return ret;
	}

	// Unlike comments I cannot simply use text_encoding here (as I don't know the length of this member, or how bridj treats null-terminating string.)
	public String getVendor ()
	{
		return c.vendor().getCString();
	}
}
