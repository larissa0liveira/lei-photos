package leiphotos.domain.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import leiphotos.domain.metadatareader.JpegMetadataException;
import leiphotos.domain.metadatareader.JpegMetadataReader;
import leiphotos.domain.metadatareader.JpegMetadataReaderFactory;

public enum PhotoFactory {

	INSTANCE;
	
	public Photo createPhoto(String title, String pathToPhotoFile) throws FileNotFoundException, JpegMetadataException {
		
		File file = new File(pathToPhotoFile);
		
		JpegMetadataReader reader = JpegMetadataReaderFactory.INSTANCE.createMetadataReader(file);
		
		double[] loc = reader.getGpsLocation();
		GPSLocation gps = new GPSLocation(loc[0],loc[1],title);
		
		PhotoMetadata meta = new PhotoMetadata(gps, reader.getDate(), reader.getCamera(), reader.getManufacturer());
		
		return new Photo(title, LocalDateTime.now(), meta, file);
	}

}
