package leiphotos.domain.core.views;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.ViewsType;

public class ViewsCatalog implements IViewsCatalog {
	
	Map<ViewsType, ILibraryView> views;

	public ViewsCatalog(MainLibrary mainLib, TrashLibrary trashLib) {
		this.views = new TreeMap<>();
		views.put(ViewsType.ALL_MAIN, (new MainLibraryView(mainLib, photo -> true)));
		views.put(ViewsType.ALL_TRASH, (new TrashLibraryView(trashLib, photo -> true)));
		views.put(ViewsType.FAVOURITES_MAIN, new MainLibraryView(mainLib, photo -> photo.isFavourite()));
		views.put(ViewsType.MOST_RECENT, new MainLibraryView(mainLib, 
				photo -> photo.capturedDate().until(LocalDateTime.now(), ChronoUnit.MONTHS) <= 12));
	}

	@Override
	public ILibraryView getView(ViewsType t) {
		return views.get(t);
	}

}
