package fr.eni.projetenchere.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;
/*
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;
*/
import fr.eni.projetenchere.dal.DAOFactory;

public class VenteManager {

	
	
	// Attribut :
	private static VenteManager instance;
	
	

	// Constructeur :
	/*
	private VenteManager() throws SQLException {
		VenteManager nouvelleVente = DAOFactory.getVenteDAO().selectAll();
	}
	*/

	
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
	 * @throws BusinessException : La BusinessException assigne un message à l'erreur levée.
	 * @throws SQLException : Les erreurs de type SQLExeception levées dans la classe VenteManagerDAOJdbcImpl sont propagéesL.
	 * @Etapes Appelle la méthode de la DAL : insertNouvelleVente(article, categorie, retrait, enchere) en lui passant les paramètre de la Servlet "NouvelleVente".
	 * @Param article : article vendu.
	 * @Param categorie : categorie de l'objet vendu.
	 * @Param retrait : endroit de retrait.
	 * @Param enchere : référence de l'enchère.
	 */
	
	public void insertNouvelleVente(Article article, Retrait retrait, Enchere enchere) throws SQLException, BusinessException{
		DAOFactory.getVenteDAO().insertNouvelleVente(article, retrait, enchere);
	}
	
	
	
	/**
	 * Méthode permettant d'appeler la méthode de la DAL : selectAllCategories().
	 * @throws BusinessException : La BusinessException assigne un message à l'erreur levée.
	 * @throws SQLException : Les erreurs de type SQLExeception levées dans la méthode selectAllCategories() sont propagées.
	 * @Etapes : Cette méthode appelle la méthode selectAllCategories() en passant en paramètre le numéro de la catégorie.
	 */
	public List<Categorie> selectAllCategories() throws SQLException, BusinessException{
		List<Categorie> listeCate;
		listeCate = DAOFactory.getVenteDAO().selectAllCategories();
		return listeCate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
