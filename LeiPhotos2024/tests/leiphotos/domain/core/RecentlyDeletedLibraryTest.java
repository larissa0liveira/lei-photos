package leiphotos.domain.core;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leiphotos.domain.facade.IPhoto;

class RecentlyDeletedLibraryTest {

	private static final int SECONDS_IN_TRASH = 15; // CHANGE ME
	private static final int SECONDS_TO_CHECK = 5; // CHANGE ME

	private RecentlyDeletedLibrary library;

	@BeforeEach
	void setUp() {
		library = new RecentlyDeletedLibrary();
	}

	@Test
	void testAddPhoto() {
		MockPhoto photo = new MockPhoto(new File("Test.jpg"));

		assertTrue(library.addPhoto(photo));
		assertTrue(library.getPhotos().contains(photo));
		assertEquals(1, library.getNumberOfPhotos());
	}

	@Test
	void testAddExistingPhoto() {
		MockPhoto photo = new MockPhoto(new File("Test.jpg"));

		assertTrue(library.addPhoto(photo));

		assertFalse(library.addPhoto(photo)); // adicionar a mesma foto novamente

		// Verifica se a foto está presente apenas uma vez na lixeira
		assertEquals(1, library.getNumberOfPhotos());

	}

	@Test
	void testDeletePhoto() {
		MockPhoto photo = new MockPhoto(new File("Test.jpg"));
		library.addPhoto(photo);

		assertTrue(library.getPhotos().contains(photo));

		assertTrue(library.deletePhoto(photo));

		assertFalse(library.getPhotos().contains(photo));

	}

	@Test
	void testDeleteNotExistingPhoto() {
		MockPhoto photo1 = new MockPhoto(new File("One.jpg"));
		MockPhoto photo2 = new MockPhoto(new File("Two.jpg"));
		library.addPhoto(photo1);

		assertFalse(library.getPhotos().contains(photo2));
		assertFalse(library.deletePhoto(photo2));

	}

	@Test
	void testDeleteAll() {
		MockPhoto photo1 = new MockPhoto(new File("One.jpg"));
		MockPhoto photo2 = new MockPhoto(new File("Two.jpg"));
		library.addPhoto(photo1);
		library.addPhoto(photo2);

		assertTrue(library.getPhotos().contains(photo1));
		assertTrue(library.getPhotos().contains(photo2));
		assertTrue(library.deleteAll());
		assertFalse(library.getPhotos().contains(photo1));
		assertFalse(library.getPhotos().contains(photo2));

	}

	@Test
	void testGetMatchesEmpty() {
		Collection<IPhoto> matches = library.getMatches(".*");
		assertNotNull(matches);

		assertTrue(matches.isEmpty());

	}

	@Test
	void testGetMatchesNotEmpty() {
		MockPhoto photoY = new MockPhoto(new File("Y.jpg"), true);
		MockPhoto photoN = new MockPhoto(new File("N.jpg"), false);
		library.addPhoto(photoY);
		library.addPhoto(photoN);
		Collection<IPhoto> matches = library.getMatches(".*");

		assertFalse(matches.isEmpty());

	}

	@Test
	void testAutomaticDelete() throws InterruptedException {
		MockPhoto photo1 = new MockPhoto(new File("One.jpg"));
		MockPhoto photo2 = new MockPhoto(new File("Two.jpg"));
		library.addPhoto(photo1);
		library.addPhoto(photo2);
		Thread.sleep(SECONDS_IN_TRASH * 1000);
		Collection<IPhoto> photos = library.getPhotos();

		assertTrue(photos.isEmpty());

	}

	@Test
	void testAutomaticDeleteNoEffectTooSoon() {
		MockPhoto photo1 = new MockPhoto(new File("One.jpg"));
		MockPhoto photo2 = new MockPhoto(new File("Two.jpg"));
		library.addPhoto(photo1);
		library.addPhoto(photo2);
		Collection<IPhoto> photos = library.getPhotos();

	/*	LocalDateTime referenceDateTime = LocalDateTime.now();

		// Defina a data e hora de referência para a hora em que as fotos foram adicionadas
		library.setLastVerificationTime(referenceDateTime);

		// Avance o tempo por um período menor do que o intervalo de tempo especificado
		LocalDateTime finalDateTime = referenceDateTime.plus(SECONDS_IN_TRASH - 1, ChronoUnit.SECONDS);
		library.setLastVerificationTime(finalDateTime);

		// Verifique se as fotos ainda estão presentes na lixeira
		assertFalse(photos.isEmpty());*/

	}

	@Test
	void testAutomaticDeleteNoEffectCheckedJustBefore() throws InterruptedException {
		MockPhoto photo1 = new MockPhoto(new File("One.jpg"));
		MockPhoto photo2 = new MockPhoto(new File("Two.jpg"));
		library.addPhoto(photo1);
		library.addPhoto(photo2);
		Thread.sleep(SECONDS_TO_CHECK * 1000);
		Collection<IPhoto> photos = library.getPhotos();

       //completar
	}

	// COMPLETE ME

}