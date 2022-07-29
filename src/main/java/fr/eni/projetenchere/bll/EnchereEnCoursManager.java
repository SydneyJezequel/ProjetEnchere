package fr.eni.projetenchere.bll;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.EnchereEnCours;
import fr.eni.projetenchere.dal.DAOFactory;

public class EnchereEnCoursManager implements Serializable {

	private static final long serialVersionUID = -421028593129521006L;
	
	// Attribut :
	private static EnchereEnCoursManager instance;

	/**
	 * Méthode de type Singleton.
	 * 
	 * @return Une Instance de la classe ListeEncheresManager.
	 * @throws SQLException
	 * @throws Exception
	 */
	public static EnchereEnCoursManager getInstance() throws SQLException {
		if (instance == null) {
			instance = new EnchereEnCoursManager();
		}
		return instance;
	}
	// Constructeur :
//	private ListeEncheresManager() throws SQLException, BusinessException {
//		List<ListeEncheresManager> listesEncheres = DAOFactory.getListeEncheresDAO().selectAll();
//	}
//	
	private EnchereEnCoursManager() {}
	
	// Méthodes
	public List<Categorie> selectionnerCategories() throws BusinessException {
		return DAOFactory.getListeEncheresDAO().selectCategories();
	}
	
	public List<EnchereEnCours> selectionnerTout() throws BusinessException, SQLException
	{
		return DAOFactory.getListeEncheresDAO().selectAll();
	}
	
	public List<EnchereEnCours> selectionnerCategorie(int noCategorie) throws BusinessException {
		return DAOFactory.getListeEncheresDAO().selectByCategorie(noCategorie);
	}
	
	public List<EnchereEnCours> selectionnerFiltre(String filtre) throws BusinessException {
		return DAOFactory.getListeEncheresDAO().selectByFilter(filtre);
	}
	
	public List<EnchereEnCours> selectionnerFiltreEtCategorie(String filtre, int noCategorie) throws BusinessException {
		return DAOFactory.getListeEncheresDAO().selectByFilterAndCategorie(filtre, noCategorie);
	}
}



