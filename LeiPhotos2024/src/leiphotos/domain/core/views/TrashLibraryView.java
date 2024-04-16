package leiphotos.domain.core.views;

import java.util.Comparator;
import java.util.List;

import leiphotos.domain.facade.IPhoto;

public class TrashLibraryView extends ALibraryView {

	@Override
	public void setComparator(Comparator<IPhoto> c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numberOfPhotos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IPhoto> getPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPhoto> getMatches(String regexp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean photoPredicate(IPhoto photo) {
		// TODO Auto-generated method stub
		return false;
	}

}
