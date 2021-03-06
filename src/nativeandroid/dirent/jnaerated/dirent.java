package nativeandroid.dirent.jnaerated;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * the following structure is really called dirent64 by the kernel<br>
 * headers. They also define a struct dirent, but the latter lack<br>
 * the d_type field which is required by some libraries (e.g. hotplug)<br>
 * who assume to be able to access it directly. sad...<br>
 * <i>native declaration : /usr/include/sys/cdefs.h:21</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("c") 
public class dirent extends StructObject {
	public dirent() {
		super();
	}
	public dirent(Pointer pointer) {
		super(pointer);
	}
	@Field(0) 
	public long d_ino() {
		return this.io.getLongField(this, 0);
	}
	@Field(0) 
	public dirent d_ino(long d_ino) {
		this.io.setLongField(this, 0, d_ino);
		return this;
	}
	@Field(1) 
	public long d_off() {
		return this.io.getLongField(this, 1);
	}
	@Field(1) 
	public dirent d_off(long d_off) {
		this.io.setLongField(this, 1, d_off);
		return this;
	}
	@Field(2) 
	public short d_reclen() {
		return this.io.getShortField(this, 2);
	}
	@Field(2) 
	public dirent d_reclen(short d_reclen) {
		this.io.setShortField(this, 2, d_reclen);
		return this;
	}
	@Field(3) 
	public byte d_type() {
		return this.io.getByteField(this, 3);
	}
	@Field(3) 
	public dirent d_type(byte d_type) {
		this.io.setByteField(this, 3, d_type);
		return this;
	}
	/// C type : char[256]
	@Array({256}) 
	@Field(4) 
	public Pointer<Byte > d_name() {
		return this.io.getPointerField(this, 4);
	}
}
