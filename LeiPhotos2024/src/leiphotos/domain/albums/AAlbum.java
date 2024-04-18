package leiphotos.domain.albums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.PhotoDeletedLibraryEvent;
import leiphotos.domain.facade.IPhoto;

public abstract class AAlbum implements IAlbum{
	
	protected String name;
	protected List<IPhoto> album;
	protected MainLibrary library;
	
	protected AAlbum(String name, MainLibrary library) {
		this.album = new ArrayList<>();
		this.name = name;
		this.library = library;
		library.registerListener(this);
	}
	
    @Override
	public int numberOfPhotos() {
		return this.album.size();
    }
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public List<IPhoto> getPhotos(){
		return new ArrayList<>(album);
	}

	@Override
	public boolean addPhotos(Set<IPhoto> selectedPhotos) {
		return this.album.addAll(selectedPhotos);
	}
	
	@Override
	public boolean removePhotos(Set<IPhoto> selectedPhotos) {
		return this.album.removeAll(selectedPhotos);
	}
	
	@Override
	public void processEvent(LibraryEvent e) {
		if(e instanceof PhotoDeletedLibraryEvent)
			album.remove(e.getPhoto());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***** Album "+ name +": "+ numberOfPhotos()+" photos *****\n");
		for(IPhoto photo : album) {
			sb.append(photo.file());
			sb.append("\n");
		}
		return sb.toString();
	}

}
