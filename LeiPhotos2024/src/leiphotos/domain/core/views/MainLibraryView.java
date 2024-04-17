package leiphotos.domain.core.views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.PhotoAddedLibraryEvent;
import leiphotos.domain.core.PhotoChangedLibraryEvent;
import leiphotos.domain.core.PhotoDeletedLibraryEvent;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.Listener;

public class MainLibraryView extends ALibraryView implements Listener<LibraryEvent>{
	
	private List<IPhoto> cache;
	
	public MainLibraryView(MainLibrary lib, Predicate<IPhoto> p) {
		super(lib, p);
		cache = lib.getPhotos().stream().filter(p).sorted(comparator).toList();
		lib.registerListener(this);
	}
	
	public MainLibraryView(MainLibrary lib, Predicate<IPhoto> p, Comparator<IPhoto> c) {
		super(lib, p);
		this.setComparator(c);
		lib.registerListener(this);
	}
	
	@Override
	public void setComparator(Comparator<IPhoto> c) {
        this.comparator = c;
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
    	List<IPhoto> matches = this.cache;
    	
    	for(IPhoto photo : matches) {
    		if(!photo.matches(regexp))
    			matches.remove(photo);
    	}
    	return matches;
	}

	@Override
	public void processEvent(LibraryEvent e) {
		if(e instanceof PhotoAddedLibraryEvent) {
			cache.add(e.getPhoto());
		} else if(e instanceof PhotoChangedLibraryEvent) {
			for(IPhoto photo : cache) {
				if(photo.equals(e.getPhoto()))
					//fazer alguma coisa
					return;
			}
		} else if(e instanceof PhotoDeletedLibraryEvent){
			cache.remove(e.getPhoto());
		}
		
	}

}
