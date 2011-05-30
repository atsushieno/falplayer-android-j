package nativeandroid.tremolo;

import nativeandroid.tremolo.jnaerated.vorbis_info;
import org.bridj.*;

public class OggVorbisInfo
{
	final vorbis_info info;

	OggVorbisInfo (vorbis_info info)
	{
		this.info = info;
	}

	/*
	public OggVorbisInfo (Pointer<Integer> ptr)
	{
		info = (vorbis_info) Marshal.PtrToStructure (ptr, typeof (VorbisInfo) );
	}
	*/

	public int getVersion (){ return info.version(); }
	public int getChannels () { return info.channels(); }
	public long getRate () { return info.rate(); }
	public long getBitrateUpper () { return info.bitrate_upper(); }
	public long getBitrateNominal () { return info.bitrate_nominal(); }
	public long getBitrateLower () { return info.bitrate_lower(); }
	public long getBitrateWindow () { return info.bitrate_window(); }
	// is it unsafe to expose?
	public Pointer<?> CodecSetup () { return info.codec_setup(); }
}
