package leiphotos.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.domain.facade.IPhoto;

class PhotoTest {

	@Test
	void testCreatePhotoWithoutGPS() {
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new File("test.jpg");
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();

		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";

		PhotoMetadata metadata = new PhotoMetadata(null, expectedCapturedDate, cameraInfo, manufacture);

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, metadata, expectedFile);

		assertEquals(expectedCapturedDate, photo.capturedDate());
		assertEquals(expectedFile, photo.file());
		assertEquals(expectedTitle, photo.title());
		assertEquals(expectedAddedDate, photo.addedDate());
		assertFalse(photo.isFavourite());
		assertFalse(photo.getPlace().isPresent());
	}

	@Test
	void testCreatePhotoWithGPS() {

		double latitude = 40.7128;
		double longitude = -74.0060;
		String description = "Descrição da localização";

		GPSLocation loc = new GPSLocation(latitude, longitude, description);

		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";

		PhotoMetadata meta = new PhotoMetadata(loc, expectedCapturedDate, cameraInfo, manufacture);

		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		File expectedFile = new File("test.jpg");

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, meta, expectedFile);

		assertEquals(expectedTitle, photo.title());
		assertEquals(expectedAddedDate, photo.addedDate());
		assertEquals(meta.getDate(), photo.capturedDate());
		assertFalse(photo.isFavourite());
		assertEquals(expectedFile, photo.file());
		assertTrue(photo.getPlace().isPresent()); // Verifique se as coordenadas GPS estão presentes
		assertEquals(loc, photo.getPlace().get()); // Verifique se as coordenadas GPS são as mesmas fornecidas

	}

	@Test
	void testToggleFavourite() {
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";

		PhotoMetadata meta = new PhotoMetadata(null, expectedCapturedDate, cameraInfo, manufacture);

		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		File expectedFile = new File("test.jpg");

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, meta, expectedFile);

		
		assertFalse(photo.isFavourite());
		
		photo.toggleFavourite();
	
		assertTrue(photo.isFavourite());

		photo.toggleFavourite();

		assertFalse(photo.isFavourite());
	}

	@Test
	void testSize() { // requires the use of a mock file class
		long expectedSize = 1024;
		MockFile expectedFile = new MockFile("test.jpg", expectedSize);
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, null, expectedFile);

		// Verifica se o tamanho retornado pelo método size() é o esperado
		assertEquals(expectedSize, photo.size());
	}

	@Test
	void testNoMatches() {
		String regexp = "Exp.*";
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		File expectedFile = new File("test.jpg");
		
		double latitude = 40.7128;
		double longitude = -74.0060;
		String description = "Descrição da localização";

		GPSLocation loc = new GPSLocation(latitude, longitude, description);

		PhotoMetadata meta = new PhotoMetadata(loc, expectedCapturedDate, cameraInfo, manufacture);

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, meta, expectedFile);

		assertFalse(photo.matches(regexp));
	}

	@Test
	void testMatchesTitle() {
		String regexp = "Test.*";
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		File expectedFile = new File("test.jpg");
		
		double latitude = 40.7128;
		double longitude = -74.0060;
		String description = "Descrição da localização";

		GPSLocation loc = new GPSLocation(latitude, longitude, description);

		PhotoMetadata meta = new PhotoMetadata(loc, expectedCapturedDate, cameraInfo, manufacture);

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, meta, expectedFile);

		assertTrue(photo.matches(regexp));

	}

	@Test
	void testMatchesFile() {
		String regexp = "test.*";
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		File expectedFile = new File("test.jpg");
		
		double latitude = 40.7128;
		double longitude = -74.0060;
		String description = "Descrição da localização";

		GPSLocation loc = new GPSLocation(latitude, longitude, description);

		PhotoMetadata meta = new PhotoMetadata(loc, expectedCapturedDate, cameraInfo, manufacture);

		IPhoto photo = new Photo(expectedTitle, expectedAddedDate, meta, expectedFile);

		assertTrue(photo.matches(regexp));

	}

	@Test
	void testEquals() {
		File file1 = new File("test1.jpg");
		File file2 = new File("test2.jpg");
		File file3 = new File("test1.jpg");

		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";

		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();

		
		IPhoto photo1 = new Photo(expectedTitle, expectedAddedDate, null, file1);
		IPhoto photo2 = new Photo(expectedTitle, expectedAddedDate, null, file2);
		IPhoto photo3 = new Photo(expectedTitle, expectedAddedDate, null, file3);

		// Verifica se photo1 é igual a si mesmo (deve retornar true)
		assertTrue(photo1.equals(photo1));

		// Verifica se photo1 é igual a photo2 (deve retornar false)
		assertFalse(photo1.equals(photo2));

		// Verifica se photo1 é igual a photo3 (deve retornar true, pois os arquivos
		// são os mesmos)
		assertTrue(photo1.equals(photo3));
	}



	@Test
	void testHashCode() {
		File file1 = new File("test1.jpg");
		File file2 = new File("test1.jpg");
		
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		String cameraInfo = "Modelo da câmera";
		String manufacture = "Fabricante da câmera";

		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();

		IPhoto photo1 = new Photo(expectedTitle, expectedAddedDate, null, file1);
        IPhoto photo2 = new Photo(expectedTitle, expectedAddedDate, null, file2);

        // Verifica se o hashCode de photo1 é diferente do hashCode de photo2 (deve retornar true)
        assertNotEquals(photo1.hashCode(), photo2.hashCode());

        // Verifica se o hashCode de photo1 é igual ao hashCode de si mesmo (deve retornar true)
        assertEquals(photo1.hashCode(), photo1.hashCode());
		
	}

	// COMPLETE ME

}