package leiphotos.domain.core;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import leiphotos.domain.facade.IPhoto;


public class RecentlyDeletedLibrary extends ATrashLibrary{
	
	private static final int INTERVAL = 60;
	private LocalDateTime lastVerif;
	private Map<IPhoto, LocalDateTime> deletionTimes;
	
	public RecentlyDeletedLibrary() {
		 super();
		 deletionTimes = new TreeMap<>();
	}

	@Override
	protected void clean() {
		for(IPhoto)
	}

	@Override
	protected boolean cleaningTime() {
		return lastVerif.until(LocalDateTime.now(), ChronoUnit.DAYS) >= INTERVAL;
	}

	@Override
	public boolean deleteAll() {
    	deletionTimes.clear();
		return (super.deleteAll() && deletionTimes.isEmpty());
    }
	
	@Override
	public boolean addPhoto(IPhoto photo) {
		deletionTimes.put(photo, LocalDateTime.now());
		return photosTrash.add(photo);
	}
	
	@Override
	public boolean deletePhoto(IPhoto photo) {
		deletionTimes.remove(photo);
		return photosTrash.remove(photo);
	}
	
	

}
