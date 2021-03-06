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
public class ogg_page extends StructObject {
	public ogg_page() {
		super();
	}
	public ogg_page(Pointer pointer) {
		super(pointer);
	}
	/// C type : ogg_reference*
	@Field(0) 
	public Pointer<ogg_reference > header() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : ogg_reference*
	@Field(0) 
	public ogg_page header(Pointer<ogg_reference > header) {
		this.io.setPointerField(this, 0, header);
		return this;
	}
	@Field(1) 
	public int header_len() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public ogg_page header_len(int header_len) {
		this.io.setIntField(this, 1, header_len);
		return this;
	}
	/// C type : ogg_reference*
	@Field(2) 
	public Pointer<ogg_reference > body() {
		return this.io.getPointerField(this, 2);
	}
	/// C type : ogg_reference*
	@Field(2) 
	public ogg_page body(Pointer<ogg_reference > body) {
		this.io.setPointerField(this, 2, body);
		return this;
	}
	@CLong 
	@Field(3) 
	public long body_len() {
		return this.io.getCLongField(this, 3);
	}
	@CLong 
	@Field(3) 
	public ogg_page body_len(long body_len) {
		this.io.setCLongField(this, 3, body_len);
		return this;
	}
}
