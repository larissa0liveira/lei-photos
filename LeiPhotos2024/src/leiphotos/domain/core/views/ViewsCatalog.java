package leiphotos.domain.core.views;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.IPhoto;
import leiphotos.domain.facade.ViewsType;

//Class automatically generated so the code compiles
//CHANGE ME
public class ViewsCatalog implements IViewsCatalog {
	
	Map<ViewsType, ILibraryView> views;

	public ViewsCatalog(MainLibrary mainLib, TrashLibrary trashLib) {
		this.views = new TreeMap<>();
		views.put(ViewsType.ALL_MAIN, (new MainLibraryView(mainLib, photo -> true)));
		views.put(ViewsType.ALL_TRASH, (new TrashLibraryView(trashLib, photo -> true)));
		views.put(ViewsType.FAVOURITES_MAIN, new MainLibraryView(mainLib, photo -> photo.isFavourite()));
		Comparator<IPhoto> recents = (ph1, ph2) -> (ph1.addedDate()).compareTo(ph2.addedDate());
		views.put(ViewsType.MOST_RECENT, new MainLibraryView(mainLib, photo -> true, recents));
	}

	@Override
	public ILibraryView getView(ViewsType t) {
		return views.get(t);
	}

}
