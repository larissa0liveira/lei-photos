package leiphotos.domain.albums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.facade.IPhoto;

//Class automatically generated so the code compiles
//CHANGE ME
public class AlbumsCatalog implements IAlbumsCatalog {
	
	private Map<MainLibrary,Album> catalogo; 
	private MainLibrary library;
	private List<Album> albums;
	private List<String> albumName;
	

	public AlbumsCatalog(MainLibrary mainLib) {
		this.library = mainLib;
		this.catalogo = new HashMap<>();
		this.albums = new ArrayList<>();
		this.albumName = new ArrayList<>();
	}

	@Override
	public boolean createAlbum(String albumName) {
		boolean create = false;
		if(!containsAlbum(albumName)) {
			Album album = new Album(albumName);
			this.catalogo.put(this.library, album);
			this.albums.add(album);
			this.albumName.add(albumName);
			create = true;
		}

		
		return create;
	}

	@Override
	public boolean deleteAlbum(String albumName) {
		 boolean delete = false;
		 if(containsAlbum(albumName)) {
				 this.catalogo.remove(this.library, this.albums.get(this.albumName.indexOf(albumName)));
				 delete = true;
			 
			 
		 }
		return delete;
	}

	@Override
	public boolean containsAlbum(String albumName) {
		
		return this.albumName.contains(albumName);
	}

	@Override
	public boolean addPhotos(String albumName, Set<IPhoto> selectedPhotos) {
		boolean add = false;
		if(containsAlbum(albumName)) {
			this.catalogo.getOrDefault(this.library, 
					this.albums.get(this.albumName.indexOf(albumName))).addPhotos(selectedPhotos);
			add = true;
		}
		return add;
	}

	@Override
	public boolean removePhotos(String albumName, Set<IPhoto> selectedPhotos) {
		boolean remove = false;
		if(containsAlbum(albumName)) {
			this.catalogo.getOrDefault(this.library, 
					this.albums.get(this.albumName.indexOf(albumName))).removePhotos(selectedPhotos);
			remove = true;
		}
	
		
		return remove;
	}

	@Override
	public List<IPhoto> getPhotos(String albumName) {
	
		return this.albums.get(this.albumName.indexOf(albumName)).getPhotos();
	}

	@Override
	public Set<String> getAlbumsNames() {
		Set<String> nameAlbums = new HashSet<>();
		 
		nameAlbums.addAll(this.albumName);

		return nameAlbums;
	}

}
