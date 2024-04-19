package leiphotos.domain.core.views;

import java.util.Comparator;
import java.util.List;

import leiphotos.domain.facade.IPhoto;

/**
 * Representa vistas de bibliotecas de fotos
 *
 */
public interface ILibraryView {

	/**
	 * Define o critério de ordenação usado para as fotos na vista.
	 * 
	 * @param c o comparador que define o critério de ordenação
	 */
	void setComparator(Comparator<IPhoto> c);

	/**
	 * Retorna o número de fotos que pertencem à vista.
	 * 
	 * @return o número de fotos na vista
	 */
	int numberOfPhotos();

	/**
	 * Retorna uma lista de fotos na vista, ordenadas de acordo com o critério de
	 * ordenação corrente.
	 * 
	 * @return uma lista de fotos ordenadas
	 */
	List<IPhoto> getPhotos();

	/**
	 * Retorna uma lista de fotos na vista que correspondem à expressão regular
	 * dada, ordenadas de acordo com o critério de ordenação corrente.
	 * 
	 * @param regexp a expressão regular a ser correspondida
	 * @return uma lista de fotos que correspondem à expressão regular
	 */
	List<IPhoto> getMatches(String regexp);
}
