package nativeandroid.tremolo.jnaerated;

import org.bridj.Callback;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.CLong;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
/**
 * <i>native declaration : /usr/include/stdio.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("vorbisidec") 
public class ov_callbacks extends StructObject {
	public ov_callbacks() {
		super();
	}
	public ov_callbacks(Pointer pointer) {
		super(pointer);
	}
	/// C type : read_func_callback
	@Field(0) 
	public Pointer<ov_callbacks.read_func_callback > read_func() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : read_func_callback
	@Field(0) 
	public ov_callbacks read_func(Pointer<ov_callbacks.read_func_callback > read_func) {
		this.io.setPointerField(this, 0, read_func);
		return this;
	}
	/// C type : seek_func_callback
	@Field(1) 
	public Pointer<ov_callbacks.seek_func_callback > seek_func() {
		return this.io.getPointerField(this, 1);
	}
	/// C type : seek_func_callback
	@Field(1) 
	public ov_callbacks seek_func(Pointer<ov_callbacks.seek_func_callback > seek_func) {
		this.io.setPointerField(this, 1, seek_func);
		return this;
	}
	/// C type : close_func_callback
	@Field(2) 
	public Pointer<ov_callbacks.close_func_callback > close_func() {
		return this.io.getPointerField(this, 2);
	}
	/// C type : close_func_callback
	@Field(2) 
	public ov_callbacks close_func(Pointer<ov_callbacks.close_func_callback > close_func) {
		this.io.setPointerField(this, 2, close_func);
		return this;
	}
	/// C type : tell_func_callback
	@Field(3) 
	public Pointer<ov_callbacks.tell_func_callback > tell_func() {
		return this.io.getPointerField(this, 3);
	}
	/// C type : tell_func_callback
	@Field(3) 
	public ov_callbacks tell_func(Pointer<ov_callbacks.tell_func_callback > tell_func) {
		this.io.setPointerField(this, 3, tell_func);
		return this;
	}
	/// <i>native declaration : /usr/include/stdio.h</i>
	public static abstract class read_func_callback extends Callback<read_func_callback > {
		@Ptr 
		public abstract long apply(Pointer<? > ptr, @Ptr long size, @Ptr long nmemb, Pointer<? > datasource);
	};
	/// <i>native declaration : /usr/include/stdio.h</i>
	public static abstract class seek_func_callback extends Callback<seek_func_callback > {
		public abstract int apply(Pointer<? > datasource, long offset, int whence);
	};
	/// <i>native declaration : /usr/include/stdio.h</i>
	public static abstract class close_func_callback extends Callback<close_func_callback > {
		public abstract int apply(Pointer<? > datasource);
	};
	/// <i>native declaration : /usr/include/stdio.h</i>
	public static abstract class tell_func_callback extends Callback<tell_func_callback > {
		@CLong 
		public abstract long apply(Pointer<? > datasource);
	};
}
