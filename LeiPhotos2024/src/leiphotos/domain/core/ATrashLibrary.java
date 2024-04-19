package leiphotos.domain.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import leiphotos.domain.facade.IPhoto;

public abstract class ATrashLibrary implements TrashLibrary{	

	protected List<IPhoto> photosTrash;
	
	protected ATrashLibrary() {
		this.photosTrash = new ArrayList<>();
	}
	
	protected abstract void clean();
	
	protected abstract boolean cleaningTime();

	@Override
	public Collection<IPhoto> getPhotos() {
	    if (cleaningTime()) {
	    	clean();
        }
        return new ArrayList<>(photosTrash);
    }
	    
	@Override
	public boolean deleteAll() {
    	this.photosTrash.clear();     
    	return photosTrash.isEmpty(); 
    }
	
	@Override
	public int getNumberOfPhotos() {
		return photosTrash.size();
	}
	
	@Override
	public boolean addPhoto(IPhoto photo) {
		if(!photosTrash.contains(photo))
			return photosTrash.add(photo);
		return false;
	}
	
	@Override
	public boolean deletePhoto(IPhoto photo) {
		return photosTrash.remove(photo);
	}
	
	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		Collection<IPhoto> match = new ArrayList<>();
		 
		for (IPhoto photo : photosTrash) {
			if(photo.matches(regexp))
				match.add(photo);
		}
		return match;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***** TRASH PHOTO LIBRARY: "+ getNumberOfPhotos() +" photos ****\n");
		for(IPhoto photo : photosTrash) {
			sb.append(photo);
		}
		return sb.toString();
	}
}
	
	
	

