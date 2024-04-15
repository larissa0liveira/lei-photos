package leiphotos.domain.core;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Pattern;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.RegExpMatchable;

public class Photo implements IPhoto, RegExpMatchable {
	
	private String title;
	private LocalDateTime date;
	private PhotoMetadata meta;
	private File path;
	private boolean favorite;

    
	
	
	public Photo(String title, LocalDateTime dateAddedLib, PhotoMetadata meta, File pathToFile) {
		this.title = title;
		this.date = dateAddedLib;
		this.meta = meta;
		this.path = pathToFile;
		this.favorite = false;
	
		
	}
	@Override
	public String title() {

		return this.title;
	}

	@Override
	public LocalDateTime capturedDate() {

		return this.meta.getDate();
	}

	@Override
	public LocalDateTime addedDate() {

		return this.date;
	}

	@Override
	public boolean isFavourite() {
		
		return this.favorite;
	}

	@Override
	public void toggleFavourite() {
		this.favorite = !this.favorite;

	}

	@Override   
	public Optional<? extends GPSCoordinates> getPlace() {
	      
		return Optional.ofNullable(this.meta.getLoc());
    
	}

	@Override
	public long size() {

		return this.path.length();
	}

	@Override
	public File file() {

		return this.path;
	}

	@Override
	public boolean matches(String regexp) {
		boolean match = false;
	    Pattern pattern = Pattern.compile(regexp);

	    if(this.meta.matches(regexp) ||  
	    		pattern.matcher(this.date.toString()).matches() || 
	    		 	pattern.matcher(this.title.toString()).matches()||
	    		 		pattern.matcher(this.path.toString()).matches()){
	    					match = true;
	
	        }
		return match;
	}

}
