package leiphotos.domain.albums;

import java.util.List;
import java.util.Set;

import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.Listener;

public interface IAlbum extends Listener<LibraryEvent>{
	
	
	/**
	 * Retorna o número de fotos no álbum
	 * @return
	 */
	int numberOfPhotos();
	
	/**
	 * Retorna o nome do álbum
	 * @return
	 */
	String getName();
	
	/**
	 * Retorna as fotos no álbum por uma dada ordem
	 * @return
	 */
	List<IPhoto> getPhotos();
	
	/**
	 * Adiciona, se possível, um conjunto de 
     * fotos da biblioteca ao álbum (retorna se a operação foi executada) 
	 * @param selectedPhotos
	 * @return
	 */
	boolean addPhotos(Set<IPhoto> selectedPhotos);
	/**
	 * Remove, se possível, um conjunto de 
     * fotos da biblioteca ao álbum (retorna se a operação foi executada; se alguma foto não existir no 
     * álbum deve ser simplesmente ignorada) 
	 * @param selectedPhotos
	 * @return
	 */
	boolean removePhotos(Set<IPhoto> selectedPhotos);

}
