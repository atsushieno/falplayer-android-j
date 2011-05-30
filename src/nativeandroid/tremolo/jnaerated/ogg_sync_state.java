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
public class ogg_sync_state extends StructObject {
	public ogg_sync_state() {
		super();
	}
	public ogg_sync_state(Pointer pointer) {
		super(pointer);
	}
	/**
	 * decode memory management pool<br>
	 * C type : ogg_buffer_state*
	 */
	@Field(0) 
	public Pointer<ogg_buffer_state > bufferpool() {
		return this.io.getPointerField(this, 0);
	}
	/**
	 * decode memory management pool<br>
	 * C type : ogg_buffer_state*
	 */
	@Field(0) 
	public ogg_sync_state bufferpool(Pointer<ogg_buffer_state > bufferpool) {
		this.io.setPointerField(this, 0, bufferpool);
		return this;
	}
	/**
	 * stream buffers<br>
	 * C type : ogg_reference*
	 */
	@Field(1) 
	public Pointer<ogg_reference > fifo_head() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * stream buffers<br>
	 * C type : ogg_reference*
	 */
	@Field(1) 
	public ogg_sync_state fifo_head(Pointer<ogg_reference > fifo_head) {
		this.io.setPointerField(this, 1, fifo_head);
		return this;
	}
	/// C type : ogg_reference*
	@Field(2) 
	public Pointer<ogg_reference > fifo_tail() {
		return this.io.getPointerField(this, 2);
	}
	/// C type : ogg_reference*
	@Field(2) 
	public ogg_sync_state fifo_tail(Pointer<ogg_reference > fifo_tail) {
		this.io.setPointerField(this, 2, fifo_tail);
		return this;
	}
	@CLong 
	@Field(3) 
	public long fifo_fill() {
		return this.io.getCLongField(this, 3);
	}
	@CLong 
	@Field(3) 
	public ogg_sync_state fifo_fill(long fifo_fill) {
		this.io.setCLongField(this, 3, fifo_fill);
		return this;
	}
	/// stream sync management
	@Field(4) 
	public int unsynced() {
		return this.io.getIntField(this, 4);
	}
	/// stream sync management
	@Field(4) 
	public ogg_sync_state unsynced(int unsynced) {
		this.io.setIntField(this, 4, unsynced);
		return this;
	}
	@Field(5) 
	public int headerbytes() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public ogg_sync_state headerbytes(int headerbytes) {
		this.io.setIntField(this, 5, headerbytes);
		return this;
	}
	@Field(6) 
	public int bodybytes() {
		return this.io.getIntField(this, 6);
	}
	@Field(6) 
	public ogg_sync_state bodybytes(int bodybytes) {
		this.io.setIntField(this, 6, bodybytes);
		return this;
	}
}
