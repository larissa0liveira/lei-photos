package leiphotos.domain.metadatareader;

import java.io.File;
import java.io.FileNotFoundException;

//JpegMetadataReaderFactory.INSTANCE.createMetadataReader(file)
public enum JpegMetadataReaderFactory {
    INSTANCE;

    public JpegMetadataReader createMetadataReader(File file) throws JpegMetadataException, FileNotFoundException {
        return new JavaXTMetadataReaderAdapter(file);
    }
}
