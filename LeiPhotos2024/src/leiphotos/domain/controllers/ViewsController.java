package leiphotos.domain.controllers;

import java.util.Comparator;
import java.util.List;

import leiphotos.domain.core.views.IViewsCatalog;
import leiphotos.domain.facade.IPhoto;
import leiphotos.domain.facade.IViewsController;
import leiphotos.domain.facade.ViewsType;


public class ViewsController implements IViewsController {
	
	IViewsCatalog views;

	public ViewsController(IViewsCatalog views) {
		this.views = views;
	}

	@Override
	public List<IPhoto> getPhotos(ViewsType viewType) {
		return views.getView(viewType).getPhotos();
	}

	@Override
	public List<IPhoto> getMatches(ViewsType viewType, String regexp) {
		return views.getView(viewType).getMatches(regexp);
	}

	@Override
	public void setSortingCriteria(ViewsType v, Comparator<IPhoto> criteria) {
		views.getView(v).setComparator(criteria);
	}

}
