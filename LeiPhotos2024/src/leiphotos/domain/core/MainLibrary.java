package leiphotos.domain.core;

import java.util.Collection;

import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.AbsSubject;

//Class automatically generated so the code compiles
//CHANGE ME
public class MainLibrary  extends AbsSubject<LibraryEvent> implements Library{
	
	private int numPhotos;
	

	@Override
	public int getNumberOfPhotos() {
		// TODO Auto-generated method stub
		return this.numPhotos;
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
