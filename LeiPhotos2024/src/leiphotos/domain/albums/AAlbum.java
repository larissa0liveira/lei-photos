package leiphotos.domain.albums;

import java.util.ArrayList;
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
		int control = this.numPhotos; 
		this.album.addAll(selectedPhotos);
		numPhotos += selectedPhotos.size();
		
		return this.numPhotos == control + selectedPhotos.size();
		
	}
	
	@Override
	public boolean removePhotos(Set<IPhoto> selectedPhotos) {
		int control = this.numPhotos;
		this.album.removeAll(selectedPhotos);
		this.numPhotos -= selectedPhotos.size();
		
		return this.numPhotos == control - selectedPhotos.size();
		
	}

}
