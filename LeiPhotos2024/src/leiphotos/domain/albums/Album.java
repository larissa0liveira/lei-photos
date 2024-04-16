package leiphotos.domain.albums;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.core.PhotoAddedLibraryEvent;
import leiphotos.domain.core.PhotoChangedLibraryEvent;
import leiphotos.domain.core.PhotoDeletedLibraryEvent;
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
		Set<IPhoto> adds = new HashSet<>();
		Set<IPhoto> removes = new HashSet<>();
		
		if (e instanceof PhotoAddedLibraryEvent) {
			PhotoAddedLibraryEvent event = (PhotoAddedLibraryEvent) e;
			IPhoto addedPhoto = event.getPhoto();
        
        	if (this.album.contains(addedPhoto)) {
        		adds.add(addedPhoto);
        		super.addPhotos(adds);
        	}
        }else if(e instanceof PhotoDeletedLibraryEvent) {
        		PhotoDeletedLibraryEvent event = (PhotoDeletedLibraryEvent) e;
        		IPhoto removedPhoto = event.getPhoto();
        		
        		if (this.album.contains(removedPhoto)) {
            		removes.add(removedPhoto);
            		super.removePhotos(removes);
            	}
        }else if() {
        	
        }
	}
 }


