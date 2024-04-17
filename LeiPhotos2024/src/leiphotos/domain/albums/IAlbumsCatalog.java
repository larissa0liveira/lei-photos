package leiphotos.domain.albums;

import java.util.List;
import java.util.Set;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.facade.IPhoto;

/**
 * Uma interface que define um catálogo de álbuns.
 * Um catálogo de álbuns permite a criação, remoção e acesso a álbuns de fotos.
 */
public interface IAlbumsCatalog {
	
	
	/**
     * Cria um novo álbum com o nome dado e o junta ao catálogo, se não existir nenhum com esse nome.
     * 
     * @param albumName o nome do álbum a ser criado
     * @return true se o álbum foi criado com sucesso e adicionado ao catálogo, false caso contrário
     */
    boolean createAlbum(String albumName);

    /**
     * Remove um álbum com o nome dado do catálogo, se existir algum com esse nome.
     * 
     * @param albumName o nome do álbum a ser removido
     * @return true se o álbum foi removido com sucesso do catálogo, false caso contrário
     */
    boolean deleteAlbum(String albumName);

    /**
     * Indica se existe no catálogo um álbum com o nome dado.
     * 
     * @param albumName o nome do álbum a ser verificado
     * @return true se existir um álbum com o nome dado no catálogo, false caso contrário
     */
    boolean containsAlbum(String albumName);

    /**
     * Adiciona ao álbum com o nome dado as fotos dadas, se existir algum álbum com esse nome.
     * 
     * @param albumName o nome do álbum ao qual as fotos serão adicionadas
     * @param selectedPhotos o conjunto de fotos a serem adicionadas ao álbum
     * @return true se as fotos foram adicionadas com sucesso ao álbum, false caso contrário
     */
    boolean addPhotos(String albumName, Set<IPhoto> selectedPhotos);

    /**
     * Remove do álbum com o nome dado as fotos dadas, se existir algum álbum com esse nome.
     * 
     * @param albumName o nome do álbum do qual as fotos serão removidas
     * @param selectedPhotos o conjunto de fotos a serem removidas do álbum
     * @return true se as fotos foram removidas com sucesso do álbum, false caso contrário
     */
    boolean removePhotos(String albumName, Set<IPhoto> selectedPhotos);

    /**
     * Retorna as fotos do álbum com o nome dado. Se não existir algum álbum com esse nome,
     * retorna uma lista vazia.
     * 
     * @param albumName o nome do álbum do qual as fotos serão obtidas
     * @return a lista de fotos do álbum, ou uma lista vazia se o álbum não existir
     */
    List<IPhoto> getPhotos(String albumName);

    /**
     * Retorna os nomes dos álbuns existentes no catálogo.
     * 
     * @return um conjunto contendo os nomes dos álbuns existentes
     */
    Set<String> getAlbumsNames();
    
    /**
     *Retorna a biblioteca principal associada a este catálogo de álbuns.
     * A biblioteca principal contém todas as fotos e recursos relacionados ao sistema.
     * 
     * @return a biblioteca principal associada a este catálogo
     */
    MainLibrary getLibrary();
    
    /**
     * Retorna o álbum com o nome especificado.
     * Se não houver um álbum com o nome fornecido, retorna null. 
     * 
     * @param name o nome do álbum a ser retornado
     * @return o álbum com o nome especificado, ou null se não existir
     */
    IAlbum getAlbum(String name);


}
