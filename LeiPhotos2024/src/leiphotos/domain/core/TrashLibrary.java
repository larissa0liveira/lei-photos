package leiphotos.domain.core;

import java.util.Collection;

import leiphotos.domain.facade.IPhoto;

/**
 * Represents a trash library that extends the Library interface
 * with a new method for emptying the trash. In this type of library, 
 * photos are automatically removed (for instance, after a certain 
 * period of time). 
 * 
 * @version malopes
 */
public interface TrashLibrary extends Library{

	/**
	 * Returns a collection of the photos in the trash library.
	 * Has side-effects: some, undefined, criteria over
	 * the photos is checked when this method is call
	 * and may result in photos to be removed from the library   
	 * 
	 * @return A collection of the photos in the library
	 * @ensures \result != null
	 */
	@Override
	public Collection<IPhoto> getPhotos();

	/**
	 * Removes all photos in the trash library
	 *
	 * @returns if some photo was removed
	 */	
	public boolean deleteAll();
	/**
	 * Returns the number of photos in the library
	 * 
	 * @return number of photos 
	 * @ensures \result >= 0 
	 */
	@Override
	int getNumberOfPhotos();
	
	/**
	 * Adds a photo to the library,
	 * if does not exist yet (based on equals)
	 * 
	 * @param photo Photo to add
	 * @requires photo != null
	 * @returns if the photo was added
	 */
	@Override
	boolean addPhoto(IPhoto photo);
	
	/**
	 * Removes a photo from the library (based on equals)
	 * if present in the library
	 * 
	 * @param photo Photo to be removed
	 * @requires photo != null
	 * @returns if the photo was removed
	 */	
	@Override
	boolean deletePhoto(IPhoto photo);
	
	/**
	 * Returns a collection with the photos in the library 
	 * that match the regexp
	 * 
	 * @param regexp The regular expression
	 * @requires regexp is a regular expression
	 * @return A collection with the photos in the library matching the expression
	 * @ensures \result != null
	 */
	@Override
	public Collection<IPhoto> getMatches(String regexp);
	
	/**
	 * Returns a String with a textual representation of the library
	 * with the number of photos and their representation. 
	 * 
	 * Alphabetic order of path to files in the disk  
	 * defines the presentation order. 
	 * 
	 * @return A String with a textual representation of the library
	 * @ensures \result != null
	 */
 	 @Override
	String toString();
	
}
