package leiphotos.domain.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import leiphotos.domain.albums.Album;
import leiphotos.domain.albums.IAlbum;
import leiphotos.domain.albums.IAlbumsCatalog;
import leiphotos.domain.facade.IAlbumsController;
import leiphotos.domain.facade.IPhoto;


public class AlbumsController implements IAlbumsController {
	
	private IAlbumsCatalog albumCatalog;
	private IAlbum currentlyAlbum;

	public AlbumsController(IAlbumsCatalog albumsCatalog) {
		this.albumCatalog = albumsCatalog;
		this.currentlyAlbum = new Album(null, this.albumCatalog.getLibrary());
		
	}
	
	@Override 
	public boolean createAlbum(String name) {
		
		return this.albumCatalog.createAlbum(name);
	}

	@Override
	public void removeAlbum() {
		if(this.currentlyAlbum != null) {
			this.albumCatalog.removePhotos(this.currentlyAlbum.getName(),
					new HashSet<>(this.currentlyAlbum.getPhotos()));
		}
			
	}

	@Override
	public void selectAlbum(String name) {
		if(this.albumCatalog.containsAlbum(name)) {
			this.currentlyAlbum = this.albumCatalog.getAlbum(name);
			
		}
	
	}

	@Override
	public void addPhotos(Set<IPhoto> selectedPhotos) {
		if(this.currentlyAlbum != null) {
			this.currentlyAlbum.addPhotos(selectedPhotos);
		}
		
	}

	@Override
	public void removePhotos(Set<IPhoto> selectedPhotos) {
		if(this.currentlyAlbum != null) {
			this.currentlyAlbum.removePhotos(selectedPhotos);
		}

	}

	@Override
	public List<IPhoto> getPhotos() {
		if(this.currentlyAlbum != null) {
			return this.currentlyAlbum.getPhotos();
		}
		
		return new ArrayList<>();
	}

	@Override
	public Optional<String> getSelectedAlbum() {
		if(this.currentlyAlbum != null) {
			return Optional.of(this.currentlyAlbum.getName());
					
		}
		return Optional.empty();
	}

	@Override
	public boolean createSmartAlbum(String name, Predicate<IPhoto> criteria) {
		return false;
	}

	@Override
	public Set<String> getAlbumNames() {
		
		return this.albumCatalog.getAlbumsNames();
	}





}
