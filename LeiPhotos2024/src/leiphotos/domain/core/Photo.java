package leiphotos.domain.core;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.RegExpMatchable;

public class Photo implements IPhoto, RegExpMatchable {
	
	private String title;
	private LocalDateTime date;
	private PhotoMetadata meta;
	private File path;
    
	
	
	public Photo(String title, LocalDateTime dateAddedLib, PhotoMetadata meta, File pathToFile) {
		this.title = title;
		this.date = dateAddedLib;
		this.meta = meta;
		this.path = pathToFile;
		
	}
	@Override
	public String title() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public LocalDateTime capturedDate() {
		// TODO Auto-generated method stub
		return this.date;
	}

	@Override
	public LocalDateTime addedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFavourite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void toggleFavourite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<? extends GPSCoordinates> getPlace() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public File file() {
		// TODO Auto-generated method stub
		return this.file();
	}

	@Override
	public boolean matches(String regexp) {
		// TODO Auto-generated method stub
		return false;
	}

}
