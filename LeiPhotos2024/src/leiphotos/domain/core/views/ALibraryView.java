package leiphotos.domain.core.views;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import leiphotos.domain.core.Library;
import leiphotos.domain.facade.IPhoto;

public abstract class ALibraryView implements ILibraryView {

	protected Library library;
	protected Comparator<IPhoto> comparator;
	protected Predicate<IPhoto> predicate;

	protected ALibraryView(Library lib, Predicate<IPhoto> pred) {
		this.library = lib;
		this.predicate = pred;
		this.comparator = (photo1, photo2) -> (int) (photo1.size() - photo2.size());
	}

	@Override
	public void setComparator(Comparator<IPhoto> c) {
		this.comparator = c;
	}

	@Override
	public int numberOfPhotos() {
		return this.getPhotos().size();
	}

	@Override
	public List<IPhoto> getPhotos() {
		return library.getPhotos().stream().filter(predicate).sorted(comparator).collect(Collectors.toList());
	}

	@Override
	public List<IPhoto> getMatches(String regexp) {
		List<IPhoto> matches = this.getPhotos();

		for (IPhoto photo : matches) {
			if (!photo.matches(regexp))
				matches.remove(photo);
		}
		return matches;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (IPhoto photo : getPhotos()) {
			sb.append(photo.file());
			sb.append("\n");
		}
		return sb.toString();
	}

}
