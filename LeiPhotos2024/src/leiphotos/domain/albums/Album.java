package leiphotos.domain.albums;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.facade.IPhoto;

public class Album extends AAlbum {
	

	public Album(String name) {
		super(name);
	}

	@Override
	public int numberOfPhotos() {
		
		return numberOfPhotos();
	}

	@Override
	public String getName() {

		return getName();
	}

	@Override
	public List<IPhoto> getPhotos() {

		return getPhotos();
	}

	@Override
	public boolean addPhotos(Set<IPhoto> selectedPhotos) {
		return addPhotos(selectedPhotos);
	}

	@Override
	public boolean removePhotos(Set<IPhoto> selectedPhotos) {
		return removePhotos(selectedPhotos);
	}

	@Override
	public void processEvent(LibraryEvent e) {

		
	}

}
