package leiphotos.domain.core.views;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

import leiphotos.domain.albums.IAlbum;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.IPhoto;
import leiphotos.domain.facade.ViewsType;

public class ViewsCatalog implements IViewsCatalog {
	
	Map<ViewsType, ILibraryView> views;

	public ViewsCatalog(MainLibrary mainLib, TrashLibrary trashLib) {
		this.views = new TreeMap<>();
		views.put(ViewsType.ALL_MAIN, (new MainLibraryView(mainLib, photo -> true)));
		views.put(ViewsType.ALL_TRASH, (new TrashLibraryView(trashLib, photo -> true)));
		views.put(ViewsType.FAVOURITES_MAIN, new MainLibraryView(mainLib, photo -> photo.isFavourite()));
		Predicate<IPhoto> isRecent = photo -> {
			if(photo.capturedDate() != null)
				return photo.capturedDate().until(LocalDateTime.now(), ChronoUnit.MONTHS) <= 12;
			else
				return false;
		};
		views.put(ViewsType.MOST_RECENT, new MainLibraryView(mainLib, isRecent));
	}

	@Override
	public ILibraryView getView(ViewsType t) {
		return views.get(t);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<ViewsType, ILibraryView> entry : views.entrySet()) {
			sb.append("***** VIEW "+ entry.getKey() +": "+ entry.getValue().numberOfPhotos() +" photos *****\n");
			sb.append(entry.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}

}
