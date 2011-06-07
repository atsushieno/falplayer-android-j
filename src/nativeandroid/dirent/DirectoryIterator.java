package nativeandroid.dirent;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.bridj.Pointer;

import nativeandroid.dirent.jnaerated.*;
import nativeandroid.dirent.jnaerated.direntLibrary.DIR;

public class DirectoryIterator implements Iterator<DirectoryEntry>
{
	public static final byte ENTRY_TYPE_BLOCK = direntLibrary.DT_BLK;
	public static final byte ENTRY_TYPE_CHARACTER = direntLibrary.DT_CHR;
	public static final byte ENTRY_TYPE_DIR = direntLibrary.DT_DIR;
	public static final byte ENTRY_TYPE_FIFO = direntLibrary.DT_FIFO;
	public static final byte ENTRY_TYPE_LINK = direntLibrary.DT_LNK;
	public static final byte ENTRY_TYPE_REG = direntLibrary.DT_REG;
	public static final byte ENTRY_TYPE_SOCKET = direntLibrary.DT_SOCK;
	public static final byte ENTRY_TYPE_UNKNOWN = direntLibrary.DT_UNKNOWN;
	public static final byte ENTRY_TYPE_WHT = direntLibrary.DT_WHT;
	
	public DirectoryIterator (String path)
	{
		this.path = path;
		d = direntLibrary.opendir(Pointer.pointerToCString(path));
		de = new DirectoryEntry (this);
	}

	String path;
	Pointer<DIR> d;
	DirectoryEntry de;
	boolean retrieved;
	
	protected void finalize ()
	{
		dispose ();
	}
	
	public void dispose ()
	{
		if (d != null)
			direntLibrary.closedir(d);
		d = null;
	}
	
	public String getPath ()
	{
		return path;
	}

	@Override
	public boolean hasNext() {
		if (retrieved)
			return true;
		de.de = direntLibrary.readdir(d);
		retrieved = de.de != null;
		return retrieved;
	}

	@Override
	public DirectoryEntry next() 
	{
		if (!hasNext ())
			return null;
		retrieved = false;
		return de;
	}

	@Override
	public void remove() {
		// not supported.
	}
}
