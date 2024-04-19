package leiphotos.domain.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leiphotos.domain.facade.IPhoto;

public class RecentlyDeletedLibrary extends ATrashLibrary {

	private static final int INTERVAL = 5; // tempo de intervalo entre uma verificação e outra
	private static final int DURATION = 15; // duração maxima de uma foto na lixeira
	private static final ChronoUnit TIMEUNIT = ChronoUnit.SECONDS;
	private LocalDateTime lastVerif;
	private Map<IPhoto, LocalDateTime> deletionTimes;

	public RecentlyDeletedLibrary() {
		super();
		deletionTimes = new HashMap<>();
		lastVerif = LocalDateTime.now();
	}

	@Override
	protected void clean() {
		Collection<IPhoto> toDelete = new HashSet<>();
		for (Map.Entry<IPhoto, LocalDateTime> entry : deletionTimes.entrySet()) {
			if (entry.getValue().until(LocalDateTime.now(), TIMEUNIT) >= DURATION)
				toDelete.add(entry.getKey());
		}
		for (IPhoto deletingPhoto : toDelete) {
			photosTrash.remove(deletingPhoto);
			deletionTimes.remove(deletingPhoto);
		}
	}

	@Override
	protected boolean cleaningTime() {
		boolean cleaningTime = lastVerif.until(LocalDateTime.now(), TIMEUNIT) >= INTERVAL;
		lastVerif = LocalDateTime.now();
		return cleaningTime;
	}

	@Override
	public boolean deleteAll() {
		deletionTimes.clear();
		return (super.deleteAll() && deletionTimes.isEmpty());
	}

	@Override
	public boolean addPhoto(IPhoto photo) {
		deletionTimes.put(photo, LocalDateTime.now());
		return super.addPhoto(photo);
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		deletionTimes.remove(photo);
		return super.deletePhoto(photo);
	}

}
