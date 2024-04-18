package leiphotos.domain.core;


import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.utils.RegExpMatchable;

public class GPSLocation implements RegExpMatchable, GPSCoordinates{
	
	private String description; 
	private double lat;
	private double lon;
	
	
	public GPSLocation(double lon, double lat, String descrip) {
		this.description = descrip;
		this.lat = lat;
		this.lon = lon;
		
	}
	@Override
	public boolean matches(String regexp) {
		return description.matches(regexp);
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
