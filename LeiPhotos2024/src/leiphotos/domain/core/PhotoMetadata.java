package leiphotos.domain.core;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import leiphotos.utils.RegExpMatchable;

public class PhotoMetadata implements  RegExpMatchable{
	
	
	private LocalDateTime date;
	private GPSLocation loc;
	private String cameraInfo;
	private String manufacturer;
	
	public PhotoMetadata(GPSLocation loc, LocalDateTime date, String cameraInfo, String manufacturer) {
		this.date = date;
		this.loc = loc;
		this.cameraInfo = cameraInfo;
		this.manufacturer = manufacturer;
		
	}

	@Override
	public boolean matches(String regexp) {
		boolean match = false; 
		
	     Pattern pattern = Pattern.compile(regexp);

	     if(pattern.matcher(this.loc.toString()).matches() ||
	    		 pattern.matcher(this.date.toString()).matches() ||
	    		 	pattern.matcher(this.cameraInfo).matches() ||
	    		 		pattern.matcher(this.manufacturer).matches()) {
	            			match = true;
	        }
		
		return match;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public GPSLocation getLoc() {
		return loc;
	}

	public void setLoc(GPSLocation loc) {
		this.loc = loc;
	}

	public String getCameraInfo() {
		return cameraInfo;
	}

	public void setCameraInfo(String cameraInfo) {
		this.cameraInfo = cameraInfo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}



}
