package leiphotos.domain.core;

import java.time.LocalDateTime;

import leiphotos.utils.RegExpMatchable;

public class PhotoMetadata implements RegExpMatchable{
	
	private GPSLocation loc;
	private LocalDateTime date;
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
	     return loc.matches(regexp) ||
	    		date.toString().matches(regexp) ||
	    		cameraInfo.matches(regexp) ||
	    		manufacturer.matches(regexp);

	}

	public LocalDateTime getDate() {
		return date;
	}

	public GPSLocation getLoc() {
		return loc;
	}

	public String getCameraInfo() {
		return cameraInfo;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	
	@Override
	public String toString() {
		return "["+loc+", "+date+", "+cameraInfo+", "+manufacturer+"]";
	}


}
