package nativeandroid.tremolo;

import org.bridj.Pointer;
import nativeandroid.tremolo.jnaerated.*;
import nativeandroid.tremolo.jnaerated.jnaeratedLibrary.FILE;

/*

//#region ogg.h

//[StructLayout (LayoutKind.Sequential)]
class OggPackBuffer
{
	public long EndByte;
	public int EndBit;
	public Pointer<Byte> Buffer;
	public Pointer<Byte> Ptr;
	public long Storage;
}

//[StructLayout (LayoutKind.Sequential)]
class OggSyncState
{
	public Pointer<Byte> Data;
	public int Storage;
	public int Fill;
	public int Returned;
	public int Unsynced;
	public int HeaderBytes;
	public int BodyBytes;
}

//[StructLayout (LayoutKind.Sequential, Size = 282)]
class OggStreamStateHeader
{
}

//[StructLayout (LayoutKind.Sequential, CharSet = CharSet.Ansi)]
class OggStreamState
{
	public Pointer<Byte> BodyData;
	public long BodyStorage;
	public long BodyFill;
	public long BodyReturned;

	public Pointer<Integer> LacingValues; // int*
	public Pointer<Integer> GranuleValues; // ogg_int64_t *

	public long LacingStorage;
	public long LacingFill;
	public long LacingPacket;
	public long LacingReturned;

	// [MarshalAs (UnmanagedType.ByValTStr, SizeConst = 282)]
	//public string Header;
	public OggStreamStateHeader Header;
	public int HeaderFill;

	public int E_O_S;
	public int B_O_S;

	public long SerialNumber;
	public long PageNumber;
	public long PacketNumber;
	public long GranulePosition;
}

//#endregion

//#region ivorbiscodec.h

//[StructLayout (LayoutKind.Sequential)]
class VorbisInfo
{
	public int Version;
	public int Channels;
	public long Rate;
	public long BitrateUpper;
	public long BitrateNominal;
	public long BitrateLower;
	public long BitrateWindow;
	public Pointer<Void> CodecSetup;
}

//[StructLayout (LayoutKind.Sequential)]
class VorbisDspState
{
	public int AnalysisP;
	public Pointer<Integer> VorbisInfo; // vorbis_info *
	public Pointer<Integer> Pcm; // ogg_int32_t **
	public Pointer<Integer> PcmRet; // ogg_int32_t **
	public int PcmStorage;
	public int PcmCurrent;
	public int PcmReturned;
	public int PreExtrapolate;
	public int EofFlag;
	public long LW;
	public long W;
	public long NW;
	public long CenterW;
	public long GranulePosision;
	public long Sequence;
	public Pointer<Void> BackendState;
}

//[StructLayout (LayoutKind.Sequential)]
class VorbisBlock
{
	public Pointer<Integer> Pcm; // ogg_int32_t **
	public OggPackBuffer OPB;
	public long LW;
	public long W;
	public long NW;
	public int PcmEnd;
	public int Mode;
	public int EofFlag;
	public long GranulePosision;
	public long Sequence;
	public Pointer<Integer> DspState; // vorbis_dsp_state * , read-only

	public Pointer<Void> LocalStore;
	public long LocalTop;
	public long LocalAlloc;
	public long TotalUse;
	public Pointer<Integer> Reap; // struct alloc_chain *
}

//[StructLayout (LayoutKind.Sequential)]
class AllocChain
{
	public Pointer<Void> Ptr;
	public Pointer<Integer> Next; // struct alloc_chain *
}

//[StructLayout (LayoutKind.Sequential)]
class VorbisComment
{
	public Pointer<Integer> UserComments; // char **
	public Pointer<Integer> CommentLengths; // int *
	public int CommentCount;
	//[MarshalAs (UnmanagedType.LPStr)]
	public String Vendor;
}

//#endregion

//#region ivorbisfile.h

delegate SizeT OvReadFunc (Pointer<Void> ptr, SizeT size, SizeT nmemb, Pointer<Void> datasource);
delegate int OvSeekFunc (Pointer<Void> datasource, long offset, int whence);
delegate int OvCloseFunc (Pointer<Void> datasource);
delegate long OvTellFunc (Pointer<Void> datasource);

//[StructLayout (LayoutKind.Sequential)]
class OvCallbacks
{
	public OvCallbacks (OvReadFunc read, OvSeekFunc seek, OvCloseFunc close, OvTellFunc tell)
	{
		ReadFunc = Marshal.GetFunctionPointerForDelegate (read);
		SeekFunc = Marshal.GetFunctionPointerForDelegate (seek);
		CloseFunc = Marshal.GetFunctionPointerForDelegate (close);
		TellFunc = Marshal.GetFunctionPointerForDelegate (tell);
	}

	public Pointer<Integer> ReadFunc;
	public Pointer<Integer> SeekFunc;
	public Pointer<Integer> CloseFunc;
	public Pointer<Integer> TellFunc;
}

//[StructLayout (LayoutKind.Sequential)]
class OggVorbisFile
{
	public Pointer<Void> DataSource;
	public int Seekable;
	public long Offset;
	public long End;
	public OggSyncState OY;

	public int Links;
	public Pointer<Integer> Offsets; // ogg_int64_t *
	public Pointer<Integer> DataOffsets; // ogg_int64_t *
	public Pointer<Integer> SerialNumbers; // ogg_uint32_t *
	public Pointer<Integer> PcmLengths; // ogg_int64_t *
	public Pointer<VorbisInfo> VorbisInfo;
	public Pointer<VorbisComment> VorbisComment;

	public long PcmOffset;
	public int ReadyState;
	public int CurrentSerialNumber;
	public int CurrentLink;

	public long BitTrack;
	public long SampTrack;
	public OggStreamState StreamState;
	public VorbisDspState DspState; // central working state
	public VorbisBlock Block; // local working space

	public OvCallbacks Callbacks;
}
*/

//#endregion

class OvMarshal
{
	static final String FileLibrary = "vorbisidec";
	static final String TremoloLibrary = "vorbisidec";

	//#region ivorbiscodec.h

	static void vorbis_info_init (Pointer<vorbis_info> vi)
	{
		jnaeratedLibrary.vorbis_info_init(vi);
	}

	static void vorbis_info_clear (Pointer<vorbis_info> vi)
	{
		jnaeratedLibrary.vorbis_info_clear(vi);
	}

	static int vorbis_info_blocksize (Pointer<vorbis_info> vi, int zo)
	{
		return jnaeratedLibrary.vorbis_info_blocksize(vi, zo);
	}

	static void vorbis_comment_init (Pointer<vorbis_comment> vc)
	{
		jnaeratedLibrary.vorbis_comment_init(vc);
	}

	static void vorbis_comment_add (Pointer<vorbis_comment> vc, Pointer<Byte> comment)
	{
		jnaeratedLibrary.vorbis_comment_add(vc, comment);
	}

	static void vorbis_comment_add_tag (Pointer<vorbis_comment> vc, Pointer<Byte> tag, Pointer<Byte> contents)
	{
		jnaeratedLibrary.vorbis_comment_add_tag(vc, tag, contents);
	}

	static Pointer<Byte> vorbis_comment_query (Pointer<vorbis_comment> vc, Pointer<Byte> tag, int count)
	{
		return jnaeratedLibrary.vorbis_comment_query(vc, tag, count);
	}

	static int vorbis_comment_query_count (Pointer<vorbis_comment> vc, Pointer<Byte> tag)
	{
		return jnaeratedLibrary.vorbis_comment_query_count(vc, tag);
	}

	static void vorbis_comment_clear (Pointer<vorbis_comment> vc)
	{
		jnaeratedLibrary.vorbis_comment_clear(vc);
	}

	/* not used yet
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_block_init (VorbisDspStatePtr v, VorbisBlockPtr vb);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_block_clear (VorbisBlockPtr vb);
	//[DllImport (TremoloLibrary)]
	static extern void vorbis_dsp_clear (VorbisDspStatePtr v);

	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_idheader (OggPacketPtr op);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_headerin (Pointer<vorbis_info> vi, Pointer<vorbis_comment> vc, OggPacketPtr op);

	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_init (VorbisDspStatePtr v, Pointer<vorbis_info> vi);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_restart (VorbisDspStatePtr v);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis (VorbisBlockPtr vb, OggPacketPtr op);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_trackonly (VorbisBlockPtr vb, OggPacketPtr op);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_blockin (VorbisDspStatePtr v, VorbisBlockPtr vb);
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_pcmout (VorbisDspStatePtr v, Pointer<Integer> pcm); // ogg_int32_t ***
	//[DllImport (TremoloLibrary)]
	static extern int vorbis_synthesis_read (VorbisDspStatePtr v, int samples);
	//[DllImport (TremoloLibrary)]
	static extern long vorbis_packet_blocksize (Pointer<vorbis_info> vi, OggPacketPtr op);
	*/

	//#endregion

	//#region ivorbisfile.h

	static int ov_clear (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_clear(vf);
	}

	static int ov_open (Pointer<FILE> f, Pointer<OggVorbis_File> vf, Pointer<Byte> initial, long ibytes)
	{
		return jnaeratedLibrary.ov_open(f, vf, initial, ibytes);
	}

	static int ov_open_callbacks (Pointer<Integer> datasource, Pointer<OggVorbis_File> vf, Pointer<Byte> initial, long ibytes, ov_callbacks callbacks)
	{
		return jnaeratedLibrary.ov_open_callbacks(datasource, vf, initial, ibytes, callbacks);
	}

	static int ov_test (Pointer<FILE> f, Pointer<OggVorbis_File> vf, Pointer<Byte> initial, long ibytes)
	{
		return jnaeratedLibrary.ov_test(f, vf, initial, ibytes);
	}

	static int ov_test_callbacks (Pointer<?> datasource, Pointer<OggVorbis_File> vf, Pointer<Byte> initial, long ibytes, ov_callbacks callbacks)
	{
		return jnaeratedLibrary.ov_test_callbacks(datasource, vf, initial, ibytes, callbacks);
	}

	static int ov_test_open (Pointer<OggVorbis_File> vf)
	{
		return jnaeratedLibrary.ov_test_open(vf);
	}

	static long ov_bitrate (Pointer<OggVorbis_File>  vf, int i)
	{
		return jnaeratedLibrary.ov_bitrate(vf, i);
	}

	static long ov_bitrate_instant (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_bitrate_instant(vf);
	}

	static long ov_streams (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_streams(vf);
	}

	static long ov_seekable (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_seekable(vf);
	}

	static long ov_serialnumber (Pointer<OggVorbis_File>  vf, int i)
	{
		return jnaeratedLibrary.ov_serialnumber(vf, i);
	}

	static long ov_raw_total (Pointer<OggVorbis_File>  vf, int i)
	{
		return jnaeratedLibrary.ov_raw_total(vf, i);
	}

	static long ov_pcm_total (Pointer<OggVorbis_File>  vf, int i)
	{
		return jnaeratedLibrary.ov_pcm_total(vf, i);
	}

	static long ov_time_total (Pointer<OggVorbis_File>  vf, int i)
	{
		return jnaeratedLibrary.ov_time_total(vf, i);
	}

	static int ov_raw_seek (Pointer<OggVorbis_File>  vf, long pos)
	{
		return jnaeratedLibrary.ov_raw_seek(vf, pos);
	}

	static int ov_pcm_seek (Pointer<OggVorbis_File>  vf, long pos)
	{
		return jnaeratedLibrary.ov_pcm_seek(vf, pos);
	}

	static int ov_pcm_seek_page (Pointer<OggVorbis_File>  vf, long pos)
	{
		return jnaeratedLibrary.ov_pcm_seek_page(vf, pos);
	}

	static int ov_time_seek (Pointer<OggVorbis_File>  vf, long pos)
	{
		return jnaeratedLibrary.ov_time_seek(vf, pos);
	}

	static long ov_raw_tell (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_raw_tell(vf);
	}

	static long ov_pcm_tell (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_pcm_tell(vf);
	}

	static long ov_time_tell (Pointer<OggVorbis_File>  vf)
	{
		return jnaeratedLibrary.ov_time_tell(vf);
	}

	//[DllImport (FileLibrary)]
	static Pointer<vorbis_info> ov_info (Pointer<OggVorbis_File>  vf, int link)
	{
		return jnaeratedLibrary.ov_info(vf, link);
	}

	static Pointer<vorbis_comment> ov_comment (Pointer<OggVorbis_File>  vf, int link)
	{
		return jnaeratedLibrary.ov_comment(vf, link);
	}

	static int ov_read (Pointer<OggVorbis_File> vf, Pointer<?> buffer, int length, Pointer<Integer> bitstream)
	{
		return jnaeratedLibrary.ov_read(vf, buffer, length, bitstream);
	}

	//[DllImport ("libc")]
	//static Pointer<FILE> fopen (String path, String mode)
	//#endregion
}
