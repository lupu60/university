package de.hsrm.cs.wwwvs.p3;


/**
 * An object of this class represents a filesystem which has exactly one 
 * root directory.
 * 
 * @author Sascha Riedl
 *
 */
public interface Filesystem {
	/**
	 * Returns the root directory fo the filesystem.
	 * @return Root directory of the filesystem
	 */
	public Directory getRoot();
}
