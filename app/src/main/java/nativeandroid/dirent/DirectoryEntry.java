/**
 * 
 */
package nativeandroid.dirent;

import nativeandroid.dirent.jnaerated.dirent;

import org.bridj.Pointer;

public class DirectoryEntry
{
	DirectoryEntry (DirectoryIterator owner)
	{
		this.owner = owner;
	}
	
	DirectoryIterator owner;
	Pointer<dirent> de;

	public DirectoryIterator getOwnerIterator ()
	{
		return owner;
	}
	
	public byte getEntryType ()
	{
		return de.get().d_type();
	}
	public String getName ()
	{
		return de.get().d_name().getCString();
	}
}