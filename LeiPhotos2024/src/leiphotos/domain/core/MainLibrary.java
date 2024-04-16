package leiphotos.domain.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import leiphotos.domain.albums.Album;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.AbsSubject;

//Class automatically generated so the code compiles
//CHANGE ME
public class MainLibrary  extends AbsSubject<LibraryEvent> implements Library{
	

	private List<IPhoto> library;
	private List<Album> albums;
	
	
	public MainLibrary() {
		super();
		this.library = new ArrayList<>();
		this.albums = new ArrayList<>();
		
	}
	

	@Override
	public int getNumberOfPhotos() {
		
		return this.library.size();
	}

	@Override
	public boolean addPhoto(IPhoto photo) {

	    
		
		return false;
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<IPhoto> getPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
