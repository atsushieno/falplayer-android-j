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
public class oggpack_buffer extends StructObject {
	public oggpack_buffer() {
		super();
	}
	public oggpack_buffer(Pointer pointer) {
		super(pointer);
	}
	@Field(0) 
	public int bitsLeftInSegment() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public oggpack_buffer bitsLeftInSegment(int bitsLeftInSegment) {
		this.io.setIntField(this, 0, bitsLeftInSegment);
		return this;
	}
	/// C type : ogg_uint32_t*
	@Field(1) 
	public Pointer<Integer> ptr() {
		return this.io.getPointerField(this, 1);
	}
	/// C type : ogg_uint32_t*
	@Field(1) 
	public oggpack_buffer ptr(Pointer<Integer> ptr) {
		this.io.setPointerField(this, 1, ptr);
		return this;
	}
	@CLong 
	@Field(2) 
	public long bitsLeftInWord() {
		return this.io.getCLongField(this, 2);
	}
	@CLong 
	@Field(2) 
	public oggpack_buffer bitsLeftInWord(long bitsLeftInWord) {
		this.io.setCLongField(this, 2, bitsLeftInWord);
		return this;
	}
	/**
	 * memory management<br>
	 * C type : ogg_reference*
	 */
	@Field(3) 
	public Pointer<ogg_reference > head() {
		return this.io.getPointerField(this, 3);
	}
	/**
	 * memory management<br>
	 * C type : ogg_reference*
	 */
	@Field(3) 
	public oggpack_buffer head(Pointer<ogg_reference > head) {
		this.io.setPointerField(this, 3, head);
		return this;
	}
	/// C type : ogg_reference*
	@Field(4) 
	public Pointer<ogg_reference > tail() {
		return this.io.getPointerField(this, 4);
	}
	/// C type : ogg_reference*
	@Field(4) 
	public oggpack_buffer tail(Pointer<ogg_reference > tail) {
		this.io.setPointerField(this, 4, tail);
		return this;
	}
	/**
	 * render the byte/bit counter API constant time<br>
	 * doesn't count the tail
	 */
	@CLong 
	@Field(5) 
	public long count() {
		return this.io.getCLongField(this, 5);
	}
	/**
	 * render the byte/bit counter API constant time<br>
	 * doesn't count the tail
	 */
	@CLong 
	@Field(5) 
	public oggpack_buffer count(long count) {
		this.io.setCLongField(this, 5, count);
		return this;
	}
}
