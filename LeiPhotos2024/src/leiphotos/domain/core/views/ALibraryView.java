package leiphotos.domain.core.views;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;


import leiphotos.domain.core.Library;
import leiphotos.domain.facade.IPhoto;

public abstract class ALibraryView implements ILibraryView{
	
	protected Library library;
	protected Comparator<IPhoto> comp;
	
	@Override
	public void setComparator(Comparator<IPhoto> c) {
        this.comp = c;
    }

    
    protected abstract boolean photoPredicate(IPhoto photo);

    
    @Override
	public int numberOfPhotos() {
        int count = 0;
        for (IPhoto photo : library.getPhotos()) {
            if (photoPredicate(photo)) {
                count++;
            }
        }
        return count;
    }

    @Override
	public List<IPhoto> getPhotos() {
    	
    	 Collection<IPhoto> photos = library.getPhotos();
         
    	 photos.removeIf(photo -> !photoPredicate(photo));
    	 
    	 return photos.stream().toList(); // ou photos.parallelStream().toList();
        
    }
    
    @Override
	public List<IPhoto> getMatches(String regexp) {
    	
    	List<IPhoto> match = getPhotos();
		 
		 for (IPhoto photo : match) {
	            if(photo.matches(regexp)) {
	                match.add(photo);
	            }
	        }
		
		return match;
	}

    	
    

}
