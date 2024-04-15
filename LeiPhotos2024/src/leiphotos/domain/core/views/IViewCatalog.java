package leiphotos.domain.core.views;

import leiphotos.domain.facade.ViewsType;

public interface IViewCatalog {
	
	ILibraryView getView(ViewsType t);

}
