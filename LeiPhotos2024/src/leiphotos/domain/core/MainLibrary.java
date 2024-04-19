package leiphotos.domain.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.AbsSubject;

public class MainLibrary extends AbsSubject<LibraryEvent> implements Library {

	private List<IPhoto> photos;

	public MainLibrary() {
		this.photos = new ArrayList<>();
	}

	@Override
	public int getNumberOfPhotos() {
		return this.photos.size();
	}

	@Override
	public boolean addPhoto(IPhoto photo) {
		boolean add = photos.add(photo);
		if (add) {
			emitEvent(new PhotoAddedLibraryEvent(photo, this));
		}
		return add;
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		boolean remove = photos.remove(photo);
		if (remove) {
			emitEvent(new PhotoDeletedLibraryEvent(photo, this));
		}
		return remove;
	}

	@Override
	public Collection<IPhoto> getPhotos() {
		return new ArrayList<>(photos);
	}

	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		Collection<IPhoto> match = new TreeSet<>();

		for (IPhoto photo : photos) {
			if (photo.matches(regexp))
				match.add(photo);
		}
		return match;
	}

	public void toggleFavourites(Set<IPhoto> selectedPhotos) {
		for (IPhoto photo : photos) {
			if (selectedPhotos.contains(photo)) {
				photo.toggleFavourite();
				emitEvent(new PhotoChangedLibraryEvent(photo, this));
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***** MAIN PHOTO LIBRARY: " + getNumberOfPhotos() + " photos *****\n");
		for (IPhoto photo : photos) {
			sb.append(photo);
		}
		return sb.toString();
	}

}
