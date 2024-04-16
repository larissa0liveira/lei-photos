package leiphotos.domain.core;


import java.util.Collection;


import leiphotos.domain.facade.IPhoto;


public class RecentlyDeletedLibrary extends ATrashLibrary{
	
	
	public RecentlyDeletedLibrary() {
		 super();
	}

	@Override
	public int getNumberOfPhotos() {
	
		return photosTrash.size();
	}

	@Override
	public boolean addPhoto(IPhoto photo) {
		
		return photosTrash.add(photo);
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		
		return photosTrash.remove(photo);
	}

	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		
		Collection<IPhoto> match = super.getPhotos();
		 
		 for (IPhoto photo : match) {
	            if(photo.matches(regexp)) {
	                match.add(photo);
	            }
	        }
		
		return match;
	}

	@Override
	protected void clean() {
		
		
		
	}

	@Override
	protected boolean cleaningTime() {
		// TODO Auto-generated method stub
		return false;
	}


}
