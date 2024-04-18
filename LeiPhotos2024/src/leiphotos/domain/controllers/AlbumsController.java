package leiphotos.domain.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import leiphotos.domain.albums.IAlbum;
import leiphotos.domain.albums.IAlbumsCatalog;
import leiphotos.domain.facade.IAlbumsController;
import leiphotos.domain.facade.IPhoto;


public class AlbumsController implements IAlbumsController {
	
	private IAlbumsCatalog albumCatalog;
	private IAlbum currentAlbum;

	public AlbumsController(IAlbumsCatalog albumsCatalog) {
		this.albumCatalog = albumsCatalog;
		this.currentAlbum = null;
	}
	
	@Override 
	public boolean createAlbum(String name) {
		return albumCatalog.createAlbum(name);
	}

	@Override
	public void removeAlbum() {
		if(currentAlbum != null) {
			albumCatalog.deleteAlbum(currentAlbum.getName());
		}
	}

	@Override
	public void selectAlbum(String name) {
		if(albumCatalog.containsAlbum(name)) {
			currentAlbum = albumCatalog.getAlbum(name);
		}
	}

	@Override
	public void addPhotos(Set<IPhoto> selectedPhotos) {
		if(currentAlbum != null) {
			currentAlbum.addPhotos(selectedPhotos);
		}
	}

	@Override
	public void removePhotos(Set<IPhoto> selectedPhotos) {
		if(currentAlbum != null) {
			currentAlbum.removePhotos(selectedPhotos);
		}
	}

	@Override
	public List<IPhoto> getPhotos() {
		if(currentAlbum != null) {
			return currentAlbum.getPhotos();
		}
		return new ArrayList<>();
	}

	@Override
	public Optional<String> getSelectedAlbum() {
		if(currentAlbum != null) {
			return Optional.of(currentAlbum.getName());	
		}
		return Optional.empty();
	}

	@Override
	public boolean createSmartAlbum(String name, Predicate<IPhoto> criteria) {
		return false;
	}

	@Override
	public Set<String> getAlbumNames() {
		return albumCatalog.getAlbumsNames();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***** ALBUMS *****\n");
		sb.append(albumCatalog);
		return sb.toString();
	}



}
