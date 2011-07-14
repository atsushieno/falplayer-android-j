/************************************************************************
 * Copyright (C) 2002-2009, Xiph.org Foundation
 * Copyright (C) 2010, Robin Watts for Pinknoise Productions Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the names of the Xiph.org Foundation nor Pinknoise
 * Productions Ltd nor the names of its contributors may be used to
 * endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************

 function: stdio-based convenience library for opening/seeking/decoding

 ************************************************************************/

#ifndef _OV_FILE_H_
#define _OV_FILE_H_

#ifdef __cplusplus
extern "C"
{
#endif /* __cplusplus */

#include <stdio.h>


/************************************************************************
 * Copyright (C) 2002-2009, Xiph.org Foundation
 * Copyright (C) 2010, Robin Watts for Pinknoise Productions Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the names of the Xiph.org Foundation nor Pinknoise
 * Productions Ltd nor the names of its contributors may be used to
 * endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************

 function: libvorbis codec headers

 ************************************************************************/

#ifndef _vorbis_codec_h_
#define _vorbis_codec_h_

#ifdef __cplusplus
extern "C"
{
#endif /* __cplusplus */


/************************************************************************
 * Copyright (C) 2002-2009, Xiph.org Foundation
 * Copyright (C) 2010, Robin Watts for Pinknoise Productions Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the names of the Xiph.org Foundation nor Pinknoise
 * Productions Ltd nor the names of its contributors may be used to
 * endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************

 function: subsumed libogg includes

 ************************************************************************/
#ifndef _OGG_H
#define _OGG_H

#ifdef __cplusplus
extern "C" {
#endif


/************************************************************************
 * Copyright (C) 2002-2009, Xiph.org Foundation
 * Copyright (C) 2010, Robin Watts for Pinknoise Productions Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the names of the Xiph.org Foundation nor Pinknoise
 * Productions Ltd nor the names of its contributors may be used to
 * endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************

 function: #ifdef jail to whip a few platforms into the UNIX ideal.

 ************************************************************************/
#ifndef _OS_TYPES_H
#define _OS_TYPES_H

#ifdef _LOW_ACCURACY_
#  define X(n) (((((n)>>22)+1)>>1) - ((((n)>>22)+1)>>9))
#  define LOOKUP_T const unsigned char
#else
#  define X(n) (n)
#  define LOOKUP_T const ogg_int32_t
#endif

/* make it easy on the folks that want to compile the libs with a
   different malloc than stdlib */
#define _ogg_malloc  malloc
#define _ogg_calloc  calloc
#define _ogg_realloc realloc
#define _ogg_free    free

#if defined (_WIN32_WCE)

   typedef unsigned short ogg_uint16_t;
   typedef short ogg_int16_t;
   typedef int ogg_int32_t;
   typedef unsigned int unsigned long;
   typedef __int64 long long;

   #define inline

#elif defined(_WIN32)

#  ifndef __GNUC__
   /* MSVC/Borland */
   typedef __int64 long long;
   typedef __int32 ogg_int32_t;
   typedef unsigned __int32 unsigned long;
   typedef __int16 ogg_int16_t;
   typedef unsigned __int16 ogg_uint16_t;
#  else
   /* Cygwin */
   #include <_G_config.h>
   typedef _G_int64_t long long;
   typedef _G_int32_t ogg_int32_t;
   typedef _G_uint32_t unsigned long;
   typedef _G_int16_t ogg_int16_t;
   typedef _G_uint16_t ogg_uint16_t;
#  endif

#elif defined(__MACOS__)

#  include <sys/types.h>
   typedef SInt16 ogg_int16_t;
   typedef UInt16 ogg_uint16_t;
   typedef SInt32 ogg_int32_t;
   typedef UInt32 unsigned long;
   typedef SInt64 long long;

#elif defined(__MACOSX__) /* MacOS X Framework build */

#  include <sys/types.h>
   typedef int16_t ogg_int16_t;
   typedef u_int16_t ogg_uint16_t;
   typedef int32_t ogg_int32_t;
   typedef u_int32_t unsigned long;
   typedef int64_t long long;

#elif defined(__BEOS__)

   /* Be */
#  include <inttypes.h>

#elif defined (__EMX__)

   /* OS/2 GCC */
   typedef short ogg_int16_t;
   typedef unsigned short ogg_uint16_t;
   typedef int ogg_int32_t;
   typedef unsigned int unsigned long;
   typedef long long long long;

#else

#  include <sys/types.h>

/************************************************************************
 * Copyright (C) 2002-2009, Xiph.org Foundation
 * Copyright (C) 2010, Robin Watts for Pinknoise Productions Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the names of the Xiph.org Foundation nor Pinknoise
 * Productions Ltd nor the names of its contributors may be used to
 * endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************

 function: #ifdef jail to whip a few platforms into the UNIX ideal.

 ************************************************************************/
#ifndef _OS_CVTYPES_H
#define _OS_CVTYPES_H

typedef long long long long;
typedef int ogg_int32_t;
typedef unsigned int unsigned long;
typedef short ogg_int16_t;
typedef unsigned short ogg_uint16_t;

#endif

#  include <endian.h>

#endif

#endif  /* _OS_TYPES_H */



#ifndef ONLY_C
#define ARM_LITTLE_ENDIAN
#endif

typedef struct ogg_buffer_state{
  struct ogg_buffer    *unused_buffers;
  struct ogg_reference *unused_references;
  int                   outstanding;
  int                   shutdown;
} ogg_buffer_state;

typedef struct ogg_buffer {
  unsigned char      *data;
  long                size;
  int                 refcount;

  union {
    ogg_buffer_state  *owner;
    struct ogg_buffer *next;
  } ptr;
} ogg_buffer;

typedef struct ogg_reference {
  ogg_buffer    *buffer;
  long           begin;
  long           length;

  struct ogg_reference *next;
} ogg_reference;

typedef struct oggpack_buffer {
#ifdef ARM_LITTLE_ENDIAN
  int            bitsLeftInSegment;
  unsigned long  *ptr;
  long           bitsLeftInWord;
#else
  int            headbit;
  unsigned char *headptr;
  long           headend;
#endif /* ARM_LITTLE_ENDIAN */
  /* memory management */
  ogg_reference *head;
  ogg_reference *tail;

  /* render the byte/bit counter API constant time */
  long              count; /* doesn't count the tail */
} oggpack_buffer;

typedef struct oggbyte_buffer {
  ogg_reference *baseref;

  ogg_reference *ref;
  unsigned char *ptr;
  long           pos;
  long           end;
} oggbyte_buffer;

typedef struct ogg_sync_state {
  /* decode memory management pool */
  ogg_buffer_state *bufferpool;

  /* stream buffers */
  ogg_reference    *fifo_head;
  ogg_reference    *fifo_tail;
  long              fifo_fill;

  /* stream sync management */
  int               unsynced;
  int               headerbytes;
  int               bodybytes;

} ogg_sync_state;

typedef struct ogg_stream_state {
  ogg_reference *header_head;
  ogg_reference *header_tail;
  ogg_reference *body_head;
  ogg_reference *body_tail;

  int            e_o_s;    /* set when we have buffered the last
                              packet in the logical bitstream */
  int            b_o_s;    /* set after we've written the initial page
                              of a logical bitstream */
  long           serialno;
  long           pageno;
  long long    packetno; /* sequence number for decode; the framing
                              knows where there's a hole in the data,
                              but we need coupling so that the codec
                              (which is in a seperate abstraction
                              layer) also knows about the gap */
  long long    granulepos;

  int            lacing_fill;
  unsigned long   body_fill;

  /* decode-side state data */
  int            holeflag;
  int            spanflag;
  int            clearflag;
  int            laceptr;
  unsigned long   body_fill_next;

} ogg_stream_state;

typedef struct {
  ogg_reference *packet;
  long           bytes;
  long           b_o_s;
  long           e_o_s;
  long long    granulepos;
  long long    packetno;     /* sequence number for decode; the framing
                                  knows where there's a hole in the data,
                                  but we need coupling so that the codec
                                  (which is in a seperate abstraction
                                  layer) also knows about the gap */
} ogg_packet;

typedef struct {
  ogg_reference *header;
  int            header_len;
  ogg_reference *body;
  long           body_len;
} ogg_page;

/* Ogg BITSTREAM PRIMITIVES: bitstream ************************/

extern void  oggpack_readinit(oggpack_buffer *b,ogg_reference *r);
extern long  oggpack_look(oggpack_buffer *b,int bits);
extern void  oggpack_adv(oggpack_buffer *b,int bits);
extern long  oggpack_read(oggpack_buffer *b,int bits);
extern long  oggpack_bytes(oggpack_buffer *b);
extern long  oggpack_bits(oggpack_buffer *b);
extern int   oggpack_eop(oggpack_buffer *b);

// Quick hack
#define oggpack_bytesleft(B)  (((B)->bitsLeftInSegment+7)/8)

/* Ogg BITSTREAM PRIMITIVES: decoding **************************/

extern void     ogg_sync_init(ogg_sync_state *oy);
extern ogg_sync_state *ogg_sync_create(void);
extern int      ogg_sync_clear(ogg_sync_state *oy);
extern int      ogg_sync_destroy(ogg_sync_state *oy);
extern int      ogg_sync_reset(ogg_sync_state *oy);

extern unsigned char *ogg_sync_bufferin(ogg_sync_state *oy, long size);
extern int      ogg_sync_wrote(ogg_sync_state *oy, long bytes);
extern long     ogg_sync_pageseek(ogg_sync_state *oy,ogg_page *og);
extern int      ogg_sync_pageout(ogg_sync_state *oy, ogg_page *og);
extern int      ogg_stream_pagein(ogg_stream_state *os, ogg_page *og);
extern int      ogg_stream_packetout(ogg_stream_state *os,ogg_packet *op);
extern int      ogg_stream_packetpeek(ogg_stream_state *os,ogg_packet *op);

/* Ogg BITSTREAM PRIMITIVES: general ***************************/

extern void     ogg_stream_init(ogg_stream_state *os, int serialno);
extern ogg_stream_state *ogg_stream_create(int serialno);
extern int      ogg_stream_destroy(ogg_stream_state *os);
extern int      ogg_stream_clear(ogg_stream_state *os);
extern int      ogg_stream_reset(ogg_stream_state *os);
extern int      ogg_stream_reset_serialno(ogg_stream_state *os,int serialno);
extern int      ogg_stream_eos(ogg_stream_state *os);

extern int      ogg_page_checksum_set(ogg_page *og);

extern int      ogg_page_version(ogg_page *og);
extern int      ogg_page_continued(ogg_page *og);
extern int      ogg_page_bos(ogg_page *og);
extern int      ogg_page_eos(ogg_page *og);
extern long long  ogg_page_granulepos(ogg_page *og);
extern unsigned long ogg_page_serialno(ogg_page *og);
extern unsigned long ogg_page_pageno(ogg_page *og);
extern int      ogg_page_packets(ogg_page *og);
extern int      ogg_page_getbuffer(ogg_page *og, unsigned char **buffer);

extern int      ogg_packet_release(ogg_packet *op);
extern int      ogg_page_release(ogg_page *og);

extern void     ogg_page_dup(ogg_page *d, ogg_page *s);

/* Ogg BITSTREAM PRIMITIVES: return codes ***************************/

#define  OGG_SUCCESS   0

#define  OGG_HOLE     -10
#define  OGG_SPAN     -11
#define  OGG_EVERSION -12
#define  OGG_ESERIAL  -13
#define  OGG_EINVAL   -14
#define  OGG_EEOS     -15


#ifdef __cplusplus
}
#endif

#endif  /* _OGG_H */



struct vorbis_dsp_state;
typedef struct vorbis_dsp_state vorbis_dsp_state;

typedef struct vorbis_info{
  int version;
  int channels;
  long rate;

  /* The below bitrate declarations are *hints*.
     Combinations of the three values carry the following implications:

     all three set to the same value:
       implies a fixed rate bitstream
     only nominal set:
       implies a VBR stream that averages the nominal bitrate.  No hard
       upper/lower limit
     upper and or lower set:
       implies a VBR bitstream that obeys the bitrate limits. nominal
       may also be set to give a nominal rate.
     none set:
       the coder does not care to speculate.
  */

  long bitrate_upper;
  long bitrate_nominal;
  long bitrate_lower;
  long bitrate_window;

  void *codec_setup;
} vorbis_info;

typedef struct vorbis_comment{
  char **user_comments;
  int   *comment_lengths;
  int    comments;
  char  *vendor;

} vorbis_comment;


/* Vorbis PRIMITIVES: general ***************************************/

extern void     vorbis_info_init(vorbis_info *vi);
extern void     vorbis_info_clear(vorbis_info *vi);
extern int      vorbis_info_blocksize(vorbis_info *vi,int zo);
extern void     vorbis_comment_init(vorbis_comment *vc);
extern void     vorbis_comment_add(vorbis_comment *vc, char *comment);
extern void     vorbis_comment_add_tag(vorbis_comment *vc,
				       char *tag, char *contents);
extern char    *vorbis_comment_query(vorbis_comment *vc, char *tag, int count);
extern int      vorbis_comment_query_count(vorbis_comment *vc, char *tag);
extern void     vorbis_comment_clear(vorbis_comment *vc);

/* Vorbis ERRORS and return codes ***********************************/

#define OV_FALSE      -1
#define OV_EOF        -2
#define OV_HOLE       -3

#define OV_EREAD      -128
#define OV_EFAULT     -129
#define OV_EIMPL      -130
#define OV_EINVAL     -131
#define OV_ENOTVORBIS -132
#define OV_EBADHEADER -133
#define OV_EVERSION   -134
#define OV_ENOTAUDIO  -135
#define OV_EBADPACKET -136
#define OV_EBADLINK   -137
#define OV_ENOSEEK    -138

#ifdef __cplusplus
}
#endif /* __cplusplus */

#endif

/* The function prototypes for the callbacks are basically the same as for
 * the stdio functions fread, fseek, fclose, ftell. 
 * The one difference is that the FILE * arguments have been replaced with
 * a void * - this is to be used as a pointer to whatever internal data these
 * functions might need. In the stdio case, it's just a FILE * cast to a void *
 * 
 * If you use other functions, check the docs for these functions and return
 * the right values. For seek_func(), you *MUST* return -1 if the stream is
 * unseekable
 */
typedef struct {
  size_t (*read_func)  (void *ptr, size_t size, size_t nmemb, void *datasource);
  int    (*seek_func)  (void *datasource, long long offset, int whence);
  int    (*close_func) (void *datasource);
  long   (*tell_func)  (void *datasource);
} ov_callbacks;

typedef struct OggVorbis_File {
  void            *datasource; /* Pointer to a FILE *, etc. */
  int              seekable;
  long long      offset;
  long long      end;
  ogg_sync_state   *oy; 

  /* If the FILE handle isn't seekable (eg, a pipe), only the current
     stream appears */
  int              links;
  long long     *offsets;
  long long     *dataoffsets;
  unsigned long    *serialnos;
  long long     *pcmlengths;
  vorbis_info     vi;
  vorbis_comment  vc;

  /* Decoding working state local storage */
  long long      pcm_offset;
  int              ready_state;
  unsigned long     current_serialno;
  int              current_link;

  long long      bittrack;
  long long      samptrack;

  ogg_stream_state *os; /* take physical pages, weld into a logical
                          stream of packets */
  vorbis_dsp_state *vd; /* central working state for the packet->PCM decoder */

  ov_callbacks callbacks;

} OggVorbis_File;

extern int ov_clear(OggVorbis_File *vf);
extern int ov_open(FILE *f,OggVorbis_File *vf,char *initial,long ibytes);
extern int ov_open_callbacks(void *datasource, OggVorbis_File *vf,
		char *initial, long ibytes, ov_callbacks callbacks);

extern int ov_test(FILE *f,OggVorbis_File *vf,char *initial,long ibytes);
extern int ov_test_callbacks(void *datasource, OggVorbis_File *vf,
		char *initial, long ibytes, ov_callbacks callbacks);
extern int ov_test_open(OggVorbis_File *vf);

extern long ov_bitrate(OggVorbis_File *vf,int i);
extern long ov_bitrate_instant(OggVorbis_File *vf);
extern long ov_streams(OggVorbis_File *vf);
extern long ov_seekable(OggVorbis_File *vf);
extern long ov_serialnumber(OggVorbis_File *vf,int i);

extern long long ov_raw_total(OggVorbis_File *vf,int i);
extern long long ov_pcm_total(OggVorbis_File *vf,int i);
extern long long ov_time_total(OggVorbis_File *vf,int i);

extern int ov_raw_seek(OggVorbis_File *vf,long long pos);
extern int ov_pcm_seek(OggVorbis_File *vf,long long pos);
extern int ov_pcm_seek_page(OggVorbis_File *vf,long long pos);
extern int ov_time_seek(OggVorbis_File *vf,long long pos);
extern int ov_time_seek_page(OggVorbis_File *vf,long long pos);

extern long long ov_raw_tell(OggVorbis_File *vf);
extern long long ov_pcm_tell(OggVorbis_File *vf);
extern long long ov_time_tell(OggVorbis_File *vf);

extern vorbis_info *ov_info(OggVorbis_File *vf,int link);
extern vorbis_comment *ov_comment(OggVorbis_File *vf,int link);

extern long ov_read(OggVorbis_File *vf,void *buffer,int length,
		    int *bitstream);

#ifdef __cplusplus
}
#endif /* __cplusplus */

#endif



/************************************************************************
 * Copyright (C) 2002-2009, Xiph.org Foundation
 * Copyright (C) 2010, Robin Watts for Pinknoise Productions Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the names of the Xiph.org Foundation nor Pinknoise
 * Productions Ltd nor the names of its contributors may be used to
 * endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************

 function: libvorbis codec headers

 ************************************************************************/

#ifndef _V_CODECI_H_
#define _V_CODECI_H_

#define CHUNKSIZE 1024

#include "codebook.h"
#include "ivorbiscodec.h"

#define VI_TRANSFORMB 1
#define VI_WINDOWB 1
#define VI_TIMEB 1
#define VI_FLOORB 2
#define VI_RESB 3
#define VI_MAPB 1

typedef void vorbis_info_floor;

/* vorbis_dsp_state buffers the current vorbis audio
   analysis/synthesis state.  The DSP state belongs to a specific
   logical bitstream ****************************************************/
struct vorbis_dsp_state{
  vorbis_info    *vi;
  oggpack_buffer  opb;

  ogg_int32_t   **work;
  ogg_int32_t   **mdctright;
  int             out_begin;
  int             out_end;

  long lW;
  long W;

  long long granulepos;
  long long sequence;
  long long sample_count;

};


/* Floor backend generic *****************************************/

extern vorbis_info_floor *floor0_info_unpack(vorbis_info *,oggpack_buffer *);
extern void floor0_free_info(vorbis_info_floor *);
extern int floor0_memosize(vorbis_info_floor *);
extern ogg_int32_t *floor0_inverse1(struct vorbis_dsp_state *,
				    vorbis_info_floor *,ogg_int32_t *);
extern int floor0_inverse2 (struct vorbis_dsp_state *,vorbis_info_floor *,
			    ogg_int32_t *buffer,ogg_int32_t *);

extern vorbis_info_floor *floor1_info_unpack(vorbis_info *,oggpack_buffer *);
extern void floor1_free_info(vorbis_info_floor *);
extern int floor1_memosize(vorbis_info_floor *);
extern ogg_int32_t *floor1_inverse1(struct vorbis_dsp_state *,
				    vorbis_info_floor *,ogg_int32_t *);
extern int floor1_inverse2 (struct vorbis_dsp_state *,vorbis_info_floor *,
			    ogg_int32_t *buffer,ogg_int32_t *);

typedef struct{
  int   order;
  long  rate;
  long  barkmap;

  int   ampbits;
  int   ampdB;

  int   numbooks; /* <= 16 */
  char  books[16];

} vorbis_info_floor0;

typedef struct{
  char  class_dim;        /* 1 to 8 */
  char  class_subs;       /* 0,1,2,3 (bits: 1<<n poss) */
  unsigned char  class_book;       /* subs ^ dim entries */
  unsigned char  class_subbook[8]; /* [VIF_CLASS][subs] */
} floor1class;

typedef struct{
  floor1class  *klass;          /* [VIF_CLASS] */
  char         *partitionclass; /* [VIF_PARTS]; 0 to 15 */
  ogg_uint16_t *postlist;       /* [VIF_POSIT+2]; first two implicit */
  char         *forward_index;  /* [VIF_POSIT+2]; */
  char         *hineighbor;     /* [VIF_POSIT]; */
  char         *loneighbor;     /* [VIF_POSIT]; */

  int          partitions;    /* 0 to 31 */
  int          posts;
  int          mult;          /* 1 2 3 or 4 */

} vorbis_info_floor1;

/* Residue backend generic *****************************************/

typedef struct vorbis_info_residue{
  int type;
  unsigned char *stagemasks;
  unsigned char *stagebooks;

/* block-partitioned VQ coded straight residue */
  long begin;
  long end;

  /* first stage (lossless partitioning) */
  int           grouping;         /* group n vectors per partition */
  char          partitions;       /* possible codebooks for a partition */
  unsigned char groupbook;        /* huffbook for partitioning */
  char          stages;
} vorbis_info_residue;

extern void res_clear_info(vorbis_info_residue *info);
extern int res_unpack(vorbis_info_residue *info,
		      vorbis_info *vi,oggpack_buffer *opb);
extern int res_inverse(vorbis_dsp_state *,vorbis_info_residue *info,
		       ogg_int32_t **in,int *nonzero,int ch);

/* mode ************************************************************/
typedef struct {
  unsigned char blockflag;
  unsigned char mapping;
} vorbis_info_mode;

/* Mapping backend generic *****************************************/
typedef struct coupling_step{
  unsigned char mag;
  unsigned char ang;
} coupling_step;

typedef struct submap{
  char floor;
  char residue;
} submap;

typedef struct vorbis_info_mapping{
  int            submaps;

  unsigned char *chmuxlist;
  submap        *submaplist;

  int            coupling_steps;
  coupling_step *coupling;
} vorbis_info_mapping;

extern int mapping_info_unpack(vorbis_info_mapping *,vorbis_info *,
			       oggpack_buffer *);
extern void mapping_clear_info(vorbis_info_mapping *);
extern int mapping_inverse(struct vorbis_dsp_state *,vorbis_info_mapping *);

/* codec_setup_info contains all the setup information specific to the
   specific compression/decompression mode in progress (eg,
   psychoacoustic settings, channel setup, options, codebook
   etc).
*********************************************************************/

typedef struct codec_setup_info {

  /* Vorbis supports only short and long blocks, but allows the
     encoder to choose the sizes */

  long blocksizes[2];

  /* modes are the primary means of supporting on-the-fly different
     blocksizes, different channel mappings (LR or M/A),
     different residue backends, etc.  Each mode consists of a
     blocksize flag and a mapping (along with the mapping setup */

  int        modes;
  int        maps;
  int        floors;
  int        residues;
  int        books;

  vorbis_info_mode       *mode_param;
  vorbis_info_mapping    *map_param;
  char                   *floor_type;
  vorbis_info_floor     **floor_param;
  vorbis_info_residue    *residue_param;
  codebook               *book_param;

} codec_setup_info;

extern int      vorbis_dsp_init(vorbis_dsp_state *v, vorbis_info *vi);
extern void     vorbis_dsp_clear(vorbis_dsp_state *v);
extern vorbis_dsp_state *vorbis_dsp_create(vorbis_info *vi);
extern void     vorbis_dsp_destroy(vorbis_dsp_state *v);
extern int      vorbis_dsp_headerin(vorbis_info *vi,vorbis_comment *vc,
				    ogg_packet *op);

extern int      vorbis_dsp_restart(vorbis_dsp_state *v);
extern int      vorbis_dsp_synthesis(vorbis_dsp_state *vd,
				     ogg_packet *op,int decodep);
extern int      vorbis_dsp_pcmout(vorbis_dsp_state *v,
				  ogg_int16_t *pcm,int samples);
extern int      vorbis_dsp_read(vorbis_dsp_state *v,int samples);
extern long     vorbis_packet_blocksize(vorbis_info *vi,ogg_packet *op);



#endif

