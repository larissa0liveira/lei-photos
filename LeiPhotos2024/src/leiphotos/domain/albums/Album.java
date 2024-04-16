package leiphotos.domain.albums;



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
		
		return super.numberOfPhotos();
	}

	@Override
	public String getName() {

		return super.getName();
	}

	@Override
	public List<IPhoto> getPhotos() {

		return super.getPhotos();
	}

	@Override
	public boolean addPhotos(Set<IPhoto> selectedPhotos) {
		return super.addPhotos(selectedPhotos);
	}

	@Override
	public boolean removePhotos(Set<IPhoto> selectedPhotos) {
		return super.removePhotos(selectedPhotos);
	}

	@Override
	public void processEvent(LibraryEvent e) {

		
	}

}
