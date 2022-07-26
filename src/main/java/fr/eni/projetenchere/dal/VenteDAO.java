package fr.eni.projetenchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bll.VenteManager;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;

/**
 * 
 * 
 * @author sjezequel
 *
 */

public interface VenteDAO {

	
	
	/**
	 * Méthode insérant une nouvelle vente dans les tables Article, Catégorie et Retrait.
	 * @throws SQLException et BusinessException propagent les Exceptions de ces types aux méthdodes qui appellent insertNouvelleVente().
	 */
	public void insertNouvelleVente(Article article,  Categorie categorie, Retrait retrait, Enchere enchere) throws SQLException, BusinessException;
	
	
	/*
	 * Méthode affichant toutes les ventes.
	 * @throws SQLException et BusinessException propagent les Exceptions de ces types aux méthdodes qui appellent insertNouvelleVente().
	 */
	public List<VenteManager> selectAll() throws SQLException, BusinessException;
	
	
	
	
	
	
}
