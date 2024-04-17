package leiphotos.domain.albums;

import java.util.List;
import java.util.Set;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.Listener;

public interface IAlbum extends Listener<LibraryEvent>{
	
	
	/**
	 * Retorna o número de fotos no álbum
	 * @return o número de fotos no álbum
	 */
	int numberOfPhotos();
	
	/**
	 * Retorna o nome do álbum
	 * @return o nome do álbum
	 */
	String getName();
	
	/**
	 * Retorna as fotos no álbum por uma dada ordem
	 * @return uma lista de fotos no álbum
	 */
	List<IPhoto> getPhotos();
	
	/**
	 * Adiciona, se possível, um conjunto de fotos da biblioteca ao álbum  
	 * @param selectedPhotos o conjunto de fotos a serem adicionadas
	 * @return true se as fotos foram adicionadas com sucesso, false caso contrário
	 */
	boolean addPhotos(Set<IPhoto> selectedPhotos);
	/**
	 * Remove, se possível, um conjunto de fotos da biblioteca ao álbum 
	 * @param selectedPhotos o conjunto de fotos a serem removidas
	 * @return true se as fotos foram removidas com sucesso, false caso contrário
	 */
	boolean removePhotos(Set<IPhoto> selectedPhotos);
	
	/**
	 * Process the given event 
	 * 
	 * @param e the event to process
	 */
	@Override
	public void processEvent(LibraryEvent e);

}
