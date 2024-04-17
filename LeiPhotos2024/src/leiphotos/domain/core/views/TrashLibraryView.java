package leiphotos.domain.core.views;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import leiphotos.domain.core.Library;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.IPhoto;

public class TrashLibraryView extends ALibraryView {

	public TrashLibraryView(TrashLibrary lib, Predicate<IPhoto> p) {
		super(lib, p);
	}

}
