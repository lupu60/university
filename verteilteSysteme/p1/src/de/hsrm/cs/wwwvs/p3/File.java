package de.hsrm.cs.wwwvs.p3;


/**
 * An object of this class represents a file in a filesystem.
 * 
 * @author Sascha Riedl
 *
 */
public interface File {
	/**
	 * Returns the name of the file.
	 * 
	 * @return Name of the file
	 */
	public String getName();
	
	/**
	 * Returns the full path to this file.
	 * 
	 * @return Full path to this file
	 */
	public String getFullPath();
	
	/**
	 * Returns the length of the file.
	 * 
	 * @return Length of the file
	 */
	public int getLength();
	
	/**
	 * Reads <code>length</code> bytes from the file, starting at <code>
	 * offset</code> and returns them as a byte array. If the offset is equal or
	 * less 0 or <code>offset + length</code> is greater than the length of the
	 * file a byte array of size 0 is returned.
	 * 
	 * @param offset Position to start reading from
	 * @param length Number of read bytes
	 * @return Byte array containing the read bytes
	 */
	public byte[] read(int offset, int length);
	
	/**
	 * Writes bytes to the file. The file will not be deleted before writing
	 * into it. This method just writes into the file at the specified position
	 * regardless of previous contents. Gaps are bridged with zeros.
	 * If the offset is negative, no bytes are written.
	 * 
	 * @param offset Position to start writing to
	 * @param data Byte array to write into file
	 */
	public void write(int offset, byte[] data);
}
