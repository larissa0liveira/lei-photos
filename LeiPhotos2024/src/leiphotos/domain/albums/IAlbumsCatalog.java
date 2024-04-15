package leiphotos.domain.albums;

import java.util.List;
import java.util.Set;

import leiphotos.domain.facade.IPhoto;

public interface IAlbumsCatalog {
	
	
	/**
	 * Cria um novo álbum com o nome dado e o junta 
     * ao catálogo, se não existir nenhum com esse nome (retorna se operação efetuada) 
	 * @param albumName
	 * @return
	 */
	boolean createAlbum(String albumName);
	/**
	 * Remove um álbum com o nome dado do catálogo, 
     * se existir algum com esse nome (retorna se operação efetuada) 
	 * @param albumName
	 * @return
	 */
	boolean deleteAlbum(String albumName);
	/**
	 * Indica se existe no catálogo um álbum com o 
     * nome dado
	 * @param albumName
	 * @return
	 */
	boolean containsAlbum(String albumName);
	/**
	 * Adiciona ao álbum 
     * com o nome dado as fotos dadas, se existir algum álbum com esse nome(retorna se operação 
     * efetuada) 
	 * @param albumName
	 * @param selectedPhotos
	 * @return
	 */
	boolean addPhotos(String albumName, Set<IPhoto> selectedPhotos);
	/**
	 * Remove ao álbum com o nome dado as fotos dadas, se existir algum álbum com esse nome (retorna se 
     * operação efetuada)
	 * @param albumName
	 * @param selectedPhotos
	 * @return
	 */
	boolean removePhotos(String albumName, Set<IPhoto> selectedPhotos);
	/**
	 * Dá as fotos do álbum com o nome dado; se 
     * não existir algum álbum com esse nome dá a lista vazia
	 * @param albumName
	 * @return
	 */
	List<IPhoto> getPhotos(String albumName);
	/**
	 * Dá os nomes dos álbuns existentes
	 * @return
	 */
	Set<String> getAlbumsNames();
	



}
