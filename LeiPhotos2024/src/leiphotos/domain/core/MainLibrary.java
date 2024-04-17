package leiphotos.domain.core;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.AbsSubject;


public class MainLibrary extends AbsSubject<LibraryEvent> implements Library{

	private Set<IPhoto> photos;

	
	public MainLibrary() {
		this.photos = new TreeSet<>();
	}

	@Override
	public int getNumberOfPhotos() {
		return this.photos.size();
	}

	@Override
	public boolean addPhoto(IPhoto photo) {
		boolean add = photos.add(photo);
        if (add) {
            emitEvent(new PhotoAddedLibraryEvent(photo, this));
        }
        return add;
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		boolean remove = photos.remove(photo);
        if (remove) {
            emitEvent(new PhotoDeletedLibraryEvent(photo, this));
        }
        return remove;
	}

	@Override
	public Collection<IPhoto> getPhotos() {
		
		return this.photos;
	}

	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		Collection<IPhoto> match = new TreeSet<>();
		 
		 for (IPhoto photo : photos) {
			 if(photo.matches(regexp))
				 match.add(photo);
		 }
		return match;
	}

	
	public String toString() {return "0";};
	

}
