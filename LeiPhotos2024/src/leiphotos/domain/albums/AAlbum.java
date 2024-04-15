package leiphotos.domain.albums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import leiphotos.domain.facade.IPhoto;

public abstract class AAlbum implements IAlbum{
	
	protected int numPhotos;
	protected String name;
	protected List<IPhoto> album;
	
	protected AAlbum(String name) {
		this.numPhotos = 0; 
		this.album = new ArrayList<>();
		this.name = name;
	}
	
    @Override
	public int numberOfPhotos() {
		return this.numPhotos;
    	
    }
	
	
	@Override
	public String getName() {
		return this.name;
		
	}
	
	@Override
	public List<IPhoto> getPhotos(){
		return this.album;
		
	}
	

	@Override
	public boolean addPhotos(Set<IPhoto> selectedPhotos) {
		boolean add = false; 
		int control = 0; 
		Iterator<IPhoto> it = selectedPhotos.iterator();
		
		while(it.hasNext()) {
			IPhoto photo = it.next();
			this.album.add(photo);
			numPhotos++;
			control++;
		}
	    if(control == selectedPhotos.size()) {
	    	add = true;
	    }
	    
		return add;
		
	}
	
	@Override
	public boolean removePhotos(Set<IPhoto> selectedPhotos) {
		boolean remove = false; 
	
		Iterator<IPhoto> it = selectedPhotos.iterator();
		
		while(it.hasNext()) {
			IPhoto photo = it.next();
			if(this.album.contains(photo)) {
				this.album.remove(photo);
				numPhotos--;
				remove = true;
			}
		}
		
		return remove;
		
	}

}
