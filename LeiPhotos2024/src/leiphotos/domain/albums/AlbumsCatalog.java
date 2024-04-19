package leiphotos.domain.albums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.facade.IPhoto;

public class AlbumsCatalog implements IAlbumsCatalog {
	
	private Map<String,IAlbum> catalogo; 
	private MainLibrary library;
	

	public AlbumsCatalog(MainLibrary mainLib) {
		this.library = mainLib;
		this.catalogo = new HashMap<>();
	}

	@Override
	public boolean createAlbum(String albumName) {
		IAlbum album = new Album(albumName, library);
		if(!containsAlbum(albumName)) {
			catalogo.put(albumName, album);
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteAlbum(String albumName) {
		if(containsAlbum(albumName)) {
			catalogo.remove(albumName);
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAlbum(String albumName) {
		return this.catalogo.containsKey(albumName);
	}

	@Override
	public boolean addPhotos(String albumName, Set<IPhoto> selectedPhotos) {
		if(containsAlbum(albumName)) {
			return catalogo.get(albumName).addPhotos(selectedPhotos);
		}
		return false;
	}

	@Override
	public boolean removePhotos(String albumName, Set<IPhoto> selectedPhotos) {
		if(containsAlbum(albumName)) {
			return catalogo.get(albumName).removePhotos(selectedPhotos);
		}
		return false;
	}

	@Override
	public List<IPhoto> getPhotos(String albumName) {
		if(containsAlbum(albumName)) {
			return catalogo.get(albumName).getPhotos();
		}
		return new ArrayList<>();
	}

	@Override
	public Set<String> getAlbumsNames() {
		return catalogo.keySet();
	}
	
	@Override
	public MainLibrary getLibrary() {
		return this.library;
	}
	@Override
	public IAlbum getAlbum(String name) {
		if(this.catalogo.containsKey(name)) {
			return this.catalogo.get(name);
		}
		return null;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, IAlbum> entry : catalogo.entrySet()) {
			sb.append(entry.getValue());
		}
		return sb.toString();
	}


	

}
