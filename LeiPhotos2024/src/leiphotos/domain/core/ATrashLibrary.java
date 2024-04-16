package leiphotos.domain.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import leiphotos.domain.facade.IPhoto;

public abstract class ATrashLibrary implements TrashLibrary{
	
	protected abstract void clean();
	protected abstract boolean cleaningTime();
	
	protected List<IPhoto> photosTrash;
	
	 protected ATrashLibrary() {
	        this.photosTrash = new ArrayList<>();
	    }

	    @Override
	    public Collection<IPhoto> getPhotos() {
	        if (cleaningTime()) {
	            clean();
	        }
	        return new ArrayList<>(this.photosTrash);
	    }
	    
	    @Override
		public boolean deleteAll() {
	 
	    	this.photosTrash.clear(); 
	    	    
	    	return photosTrash.isEmpty(); 
	    	
	    }
}
	
	
	

