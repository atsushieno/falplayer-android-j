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
@Library("nativeandroid.tremolo.jnaerated") 
public class ogg_reference extends StructObject {
	public ogg_reference() {
		super();
	}
	public ogg_reference(Pointer pointer) {
		super(pointer);
	}
	/// C type : ogg_buffer*
	@Field(0) 
	public Pointer<ogg_buffer > buffer() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : ogg_buffer*
	@Field(0) 
	public ogg_reference buffer(Pointer<ogg_buffer > buffer) {
		this.io.setPointerField(this, 0, buffer);
		return this;
	}
	@CLong 
	@Field(1) 
	public long begin() {
		return this.io.getCLongField(this, 1);
	}
	@CLong 
	@Field(1) 
	public ogg_reference begin(long begin) {
		this.io.setCLongField(this, 1, begin);
		return this;
	}
	@CLong 
	@Field(2) 
	public long length() {
		return this.io.getCLongField(this, 2);
	}
	@CLong 
	@Field(2) 
	public ogg_reference length(long length) {
		this.io.setCLongField(this, 2, length);
		return this;
	}
	/// C type : ogg_reference*
	@Field(3) 
	public Pointer<ogg_reference > next() {
		return this.io.getPointerField(this, 3);
	}
	/// C type : ogg_reference*
	@Field(3) 
	public ogg_reference next(Pointer<ogg_reference > next) {
		this.io.setPointerField(this, 3, next);
		return this;
	}
}