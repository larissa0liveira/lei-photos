package leiphotos.domain.metadatareader;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import leiphotos.services.JavaXTJpegMetadataReader;

public class JavaXTMetadataReaderAdapter implements JpegMetadataReader{
	
	JavaXTJpegMetadataReader reader;

	public JavaXTMetadataReaderAdapter(File file)  throws JpegMetadataException, FileNotFoundException {
		try {
			this.reader = new JavaXTJpegMetadataReader(file);
		} catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                throw (FileNotFoundException) e;
            } else {
                throw new JpegMetadataException("Erro ao ler os metadados da imagem");
            }
        }
	}

	@Override
	public String getCamera() {
		return reader.getCamara();
	}

	@Override
	public String getManufacturer() {
		return reader.getManufacturer();
	}

	@Override
	public LocalDateTime getDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss", Locale.ENGLISH);
        return LocalDateTime.parse(reader.getDate(), formatter);
	}

	@Override
	public String getAperture() {
		return reader.getAperture();
	}

	@Override
	public double[] getGpsLocation() {
		return reader.getGPS();
	}

}
