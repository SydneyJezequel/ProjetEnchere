package fr.eni.projetenchere.bll;

import java.sql.SQLException;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.dal.DAOFactory;

public class VenteManager {

	
	
	// Attribut :
	private static VenteManager instance;
	
	

	// Constructeur :
	
	private VenteManager() throws SQLException {
		VenteManager nouvelleVente = DAOFactory.getVenteDAO().selectAll();
	}
	

	
	/**
	 * Méthode de type Singleton.
	 * 
	 * @return Une Instance de la classe NouvelleVenteManager.
	 * @throws SQLException
	 * @throws Exception
	 */
	public static VenteManager getInstance() throws SQLException {
		if (instance == null) {
			instance = new VenteManager();
		}
		return instance;
	}

	
	
	
	
	/*-------------------------------- Méthodes --------------------------------*/

	/**
	 * Méthode permettant d'appeler la méthode de la DAL : insertNouvelleVente(Article article, Categorie categorie, Retrait retrait).
	 * @throws BusinessException 
	 * @throws SQLException 
	 * @Etapes XXXXXX A COMPLETER XXXXXX
	 * @throws Exception : Les exceptions sont propagées depuis la classe
	 *                   UtilisateurDAOJdbcImpl.
	 */
	public void insertNouvelleVente(Article article,  Categorie categorie, Retrait retrait, Enchere enchere) throws SQLException, BusinessException{
		DAOFactory.getVenteDAO().insertNouvelleVente(article, categorie, retrait, enchere);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
