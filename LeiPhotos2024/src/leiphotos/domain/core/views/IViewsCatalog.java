package leiphotos.domain.core.views;

import leiphotos.domain.facade.ViewsType;

/**
 * Uma interface que define um catálogo de visualizações. Um catálogo de
 * visualizações permite recuperar visualizações correspondentes a tipos
 * específicos.
 */
public interface IViewsCatalog {

	/**
	 * Retorna a visualização correspondente ao tipo especificado.
	 * 
	 * @param t o tipo de visualização desejada
	 * @return a visualização correspondente ao tipo especificado, ou null se não
	 *         houver uma visualização correspondente
	 */
	public ILibraryView getView(ViewsType t);

}
