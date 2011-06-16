package nativeandroid.tremolo.jnaerated;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.CLong;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("vorbisidec") 
public class ogg_packet extends StructObject {
	public ogg_packet() {
		super();
	}
	public ogg_packet(Pointer pointer) {
		super(pointer);
	}
	/// C type : ogg_reference*
	@Field(0) 
	public Pointer<ogg_reference > packet() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : ogg_reference*
	@Field(0) 
	public ogg_packet packet(Pointer<ogg_reference > packet) {
		this.io.setPointerField(this, 0, packet);
		return this;
	}
	@CLong 
	@Field(1) 
	public long bytes() {
		return this.io.getCLongField(this, 1);
	}
	@CLong 
	@Field(1) 
	public ogg_packet bytes(long bytes) {
		this.io.setCLongField(this, 1, bytes);
		return this;
	}
	@CLong 
	@Field(2) 
	public long b_o_s() {
		return this.io.getCLongField(this, 2);
	}
	@CLong 
	@Field(2) 
	public ogg_packet b_o_s(long b_o_s) {
		this.io.setCLongField(this, 2, b_o_s);
		return this;
	}
	@CLong 
	@Field(3) 
	public long e_o_s() {
		return this.io.getCLongField(this, 3);
	}
	@CLong 
	@Field(3) 
	public ogg_packet e_o_s(long e_o_s) {
		this.io.setCLongField(this, 3, e_o_s);
		return this;
	}
}
