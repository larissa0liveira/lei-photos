package leiphotos.domain.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import leiphotos.domain.facade.IPhoto;

public abstract class ATrashLibrary implements TrashLibrary{	

	protected Set<IPhoto> photosTrash;
	
	protected ATrashLibrary() {
		this.photosTrash = new HashSet<>();
	}
	
	protected abstract void clean();
	
	protected abstract boolean cleaningTime();

	@Override
	public Collection<IPhoto> getPhotos() {
	    if (cleaningTime()) {
	    	clean();
        }
        return photosTrash;
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
		return photosTrash.add(photo);
	}
	
	@Override
	public boolean deletePhoto(IPhoto photo) {
		return photosTrash.remove(photo);
	}
	
	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		Collection<IPhoto> match = new HashSet<>();
		 
		for (IPhoto photo : photosTrash) {
			if(photo.matches(regexp))
				match.add(photo);
		}
		return match;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(IPhoto photo : photosTrash) {
			sb.append(photo);
		}
		return sb.toString();
	}
}
	
	
	

