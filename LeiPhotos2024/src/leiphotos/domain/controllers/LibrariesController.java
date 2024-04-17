package leiphotos.domain.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.PhotoFactory;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.ILibrariesController;
import leiphotos.domain.facade.IPhoto;

public class LibrariesController implements ILibrariesController {
	
	MainLibrary mainLib;
	TrashLibrary trashLib;

	public LibrariesController(MainLibrary mainLib, TrashLibrary trashLib) {
		this.mainLib = mainLib;
		this.trashLib = trashLib;
	}

	@Override
	public Optional<IPhoto> importPhoto(String title, String pathToPhotoFile) {
		IPhoto photo = null;
		try {
			photo = PhotoFactory.INSTANCE.createPhoto(title, pathToPhotoFile);
		}catch (Exception e) {
			System.out.println("Erro ao criar foto - LibrariesController.importPhoto()");
		}
		if(mainLib.addPhoto(photo))
			return Optional.of(photo);
		return Optional.empty();
	}

	@Override
	public void deletePhotos(Set<IPhoto> selectedPhotos) {
		for(IPhoto photo : selectedPhotos) {
			if(mainLib.deletePhoto(photo))
				trashLib.addPhoto(photo);
		}

	}

	@Override
	public void emptyTrash() {
		trashLib.deleteAll();

	}

	@Override
	public void toggleFavourite(Set<IPhoto> selectedPhotos) {
		Collection<IPhoto> main = mainLib.getPhotos();
		for(IPhoto photo : main) {
			if(selectedPhotos.contains(photo))
				photo.toggleFavourite();
		}
	}

	@Override
	public Iterable<IPhoto> getMatches(String regExp) {
		List<IPhoto> matches = new ArrayList<>();
		for(IPhoto photo : mainLib.getPhotos()) {
			if(photo.matches(regExp))
				matches.add(photo);
		}
		return matches;
	}

}
