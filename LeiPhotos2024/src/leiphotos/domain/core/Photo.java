package leiphotos.domain.core;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.RegExpMatchable;

public class Photo implements IPhoto, RegExpMatchable {
	
	private String title;
	private LocalDateTime addedDate;
	private PhotoMetadata meta;
	private File path;
	private boolean favorite;

	public Photo(String title, LocalDateTime dateAddedLib, PhotoMetadata meta, File pathToFile) {
		this.title = title;
		this.addedDate = dateAddedLib;
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
		return this.addedDate;
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
	    return  addedDate.toString().matches(regexp) || 
	    		title.matches(regexp)||
	    		path.toString().matches(regexp);
	    		//meta.matches(regexp);
	}
	
//	@Override
//	public boolean equals(Object other) {
//		if(this == other)
//			return true;
//		if(other == null)
//			return false;
//		if(other instanceof Photo p)
//			return this.title.equals(p.title) &&
//					this.meta.equals(p.meta);
//		else
//			return false;
//	};
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(',');
		return "File:" + path + "\n" +
				"Title:" + title + " " +
				"Added:" + addedDate.format(formatter) + " " +
				"Size:" + new DecimalFormat("#,###", symbols).format(size()) + "\n" +
				meta + " "+
				(favorite ? "FAV\n" : "\n");
	}

}
