package nativeandroid.tremolo.jnaerated;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.CLong;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * vorbis_dsp_state buffers the current vorbis audio<br>
 * analysis/synthesis state.  The DSP state belongs to a specific<br>
 * logical bitstream ***************************************************<br>
 * <i>native declaration : line 56</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("vorbisidec") 
public class vorbis_dsp_state extends StructObject {
	public vorbis_dsp_state() {
		super();
	}
	public vorbis_dsp_state(Pointer pointer) {
		super(pointer);
	}
	/// C type : vorbis_info*
	@Field(0) 
	public Pointer<vorbis_info > vi() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : vorbis_info*
	@Field(0) 
	public vorbis_dsp_state vi(Pointer<vorbis_info > vi) {
		this.io.setPointerField(this, 0, vi);
		return this;
	}
	/// C type : ogg_int32_t**
	@Field(2) 
	public Pointer<Pointer<Integer> > work() {
		return this.io.getPointerField(this, 2);
	}
	/// C type : ogg_int32_t**
	@Field(2) 
	public vorbis_dsp_state work(Pointer<Pointer<Integer> > work) {
		this.io.setPointerField(this, 2, work);
		return this;
	}
	/// C type : ogg_int32_t**
	@Field(3) 
	public Pointer<Pointer<Integer> > mdctright() {
		return this.io.getPointerField(this, 3);
	}
	/// C type : ogg_int32_t**
	@Field(3) 
	public vorbis_dsp_state mdctright(Pointer<Pointer<Integer> > mdctright) {
		this.io.setPointerField(this, 3, mdctright);
		return this;
	}
	@Field(4) 
	public int out_begin() {
		return this.io.getIntField(this, 4);
	}
	@Field(4) 
	public vorbis_dsp_state out_begin(int out_begin) {
		this.io.setIntField(this, 4, out_begin);
		return this;
	}
	@Field(5) 
	public int out_end() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public vorbis_dsp_state out_end(int out_end) {
		this.io.setIntField(this, 5, out_end);
		return this;
	}
	@CLong 
	@Field(6) 
	public long lW() {
		return this.io.getCLongField(this, 6);
	}
	@CLong 
	@Field(6) 
	public vorbis_dsp_state lW(long lW) {
		this.io.setCLongField(this, 6, lW);
		return this;
	}
	@CLong 
	@Field(7) 
	public long W() {
		return this.io.getCLongField(this, 7);
	}
	@CLong 
	@Field(7) 
	public vorbis_dsp_state W(long W) {
		this.io.setCLongField(this, 7, W);
		return this;
	}
}
