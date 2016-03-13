package de.hsrm.cs.wwwvs.p3;

import java.util.List;

/**
 * An object of this class represents a directory in a filesystem. A directory
 * can contain directories (called subdirectories) and files.
 * 
 * @author Sascha Riedl
 *
 */
public interface Directory {
	/**
	 * Returns the name of this directory.
	 * 
	 * @return Name of this directory
	 */
	public String getName();
	
	/**
	 * Returns the full path to this directory.
	 * 
	 * @return Full path to this directory
	 */
	public String getFullPath();
	
	/**
	 * Returns the parent directory, or itself, if it is the root.
	 * 
	 * @return Parent directory
	 */
	public Directory getParent();
	
	/**
	 * Returns a list of all subdirectories.
	 * 
	 * @return List of all subdirectories; Empty list if directory contains no subdirectories
	 */
	public List<Directory> listDirectories();
	
	/**
	 * Returns a list with all files in the directory.
	 * 
	 * @return List of all files in the directory; Empty list if directory contains no files
	 */
	public List<File> listFiles();
	
	/**
	 * Creates a new subdirectory in this directory. If the directory name
	 * already exists, no new directory will be created.
	 * 
	 * @param name Name of the new subdirectory
	 */
	public void createDirectory(String name);
	
	/**
	 * Creates a new file in this directory. If the file name already exists, no
	 * new file will be created. The new file will also be bound to the RMI
	 * registry.
	 * 
	 * @param name Name of the new file
	 */
	public void createFile(String name);
	
	/**
	 * Deletes the directory <code>name</name>. If the directory
	 * <code>name</code> doesn't exist, nothing will be changed.
	 * 
	 * @param name Name of the directory which will be deleted
	 */
	public void deleteDirectory(String name);
	
	/**
	 * Deletes the file <code>name</name>. If the file <code>name</code> doesn't
	 * exist, nothing will be changed.
	 * 
	 * @param name Name of the file which will be deleted
	 */
	public void deleteFile(String name);
	
	/**
	 * Returns the directory <code>name</code>. If the requested directory
	 * doesn't exist, null will be returned.
	 * 
	 * @param name Name of the requested directory
	 * @return The requested directory; null, if requested directory doesn't exist
	 */
	public Directory getDirectory(String name);
	
	/**
	 * Returns the file <code>name</code>. If the requested file doesn't exist,
	 * null will be returned.
	 * 
	 * @param name Name of the requested file
	 * @return The requested file; null, if requested file doesn't exist
	 */
	public File getFile(String name);
}
