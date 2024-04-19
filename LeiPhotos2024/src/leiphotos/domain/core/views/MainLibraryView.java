package leiphotos.domain.core.views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.PhotoAddedLibraryEvent;
import leiphotos.domain.core.PhotoChangedLibraryEvent;
import leiphotos.domain.core.PhotoDeletedLibraryEvent;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.Listener;

public class MainLibraryView extends ALibraryView implements Listener<LibraryEvent> {

	private List<IPhoto> cache;

	public MainLibraryView(MainLibrary lib, Predicate<IPhoto> p) {
		super(lib, p);
		updateCache();
		lib.registerListener(this);
	}

	public void updateCache() {
		cache = super.getPhotos();
	}

	@Override
	public void setComparator(Comparator<IPhoto> c) {
		super.setComparator(c);
		cache.sort(c);
	}

	@Override
	public int numberOfPhotos() {
		return this.cache.size();
	}

	@Override
	public List<IPhoto> getPhotos() {
		return new ArrayList<>(cache);
	}

	@Override
	public List<IPhoto> getMatches(String regexp) {
		List<IPhoto> matches = new ArrayList<>();

		for (IPhoto photo : cache) {
			if (photo.matches(regexp))
				matches.add(photo);
		}
		return matches;
	}

	@Override
	public void processEvent(LibraryEvent e) {
		if (e instanceof PhotoAddedLibraryEvent) {
			if (predicate.test(e.getPhoto())) {
				cache.add(e.getPhoto());
				cache.sort(comparator);
			}
		} else if (e instanceof PhotoChangedLibraryEvent) {
			updateCache();
		} else if (e instanceof PhotoDeletedLibraryEvent) {
			cache.remove(e.getPhoto());
			cache.sort(comparator);
		}
	}

}
