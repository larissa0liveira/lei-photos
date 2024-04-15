package leiphotos.domain.core;

import java.util.regex.Pattern;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.utils.RegExpMatchable;

public class GPSLocation implements RegExpMatchable, GPSCoordinates{
	
	private String description; 
	private double lat;
	private double lon;
	
	
	public GPSLocation(double lat, double lon, String descrip) {
		this.description = descrip;
		this.lat = lat;
		this.lon = lon;
		
	}
	@Override
	public boolean matches(String regexp) {
		 boolean match = false;
	     Pattern pattern = Pattern.compile(regexp);

	     if (pattern.matcher(this.description).matches()) {
	            match = true;
	        }
		
		return match;
	}
	@Override
	public double latitude() {

		return this.lat;
	}
	@Override
	public double longitude() {

		return this.lon;
	}

}
