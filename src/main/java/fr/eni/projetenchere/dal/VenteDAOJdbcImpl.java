package fr.eni.projetenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bll.VenteManager;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.bo.Utilisateur;

public class VenteDAOJdbcImpl implements VenteDAO {


	// Constructeur
	public VenteDAOJdbcImpl() {}
	

	// Requêtes paramétrées :
	/*
	private static final String INSERT_ARTICLE = "INSERT INTO Article (nom_Article, description, categorie, photo_Article, prix_Depart, prix_Vente, Date_Debut_Enchere, Date_Fin_Enchere) VALUES (?, ?, ?, ?, ?, ?, ?, ?);"
	private static final String INSERT_CATEGORIE = "INSERT INTO Categorie (noCategorie) VALUES (?);"
	private static final String INSERT_RETRAIT = "INSERT INTO Retrait (noRetrait, rue, code_Postal, ville, no_Article) VALUES (?, ?, ?, ?, ?);"
	*/

	/*-------------------------------------- METHODES -------------------------------------- */

	/**
	 * Méthode sélectionnant un Utilisateur par son Identifiant.
	 * 
	 * @param Identifiant de l'utilisateur.
	 * @Etapes : La méthode se connecte à la BDD, exécute la requête paramétrée
	 *         SEELECT_BY_ID, récupère les données sélectionnée en s'appuyant sur la
	 *         méthode "map(rs)".
	 * @throws SQLException : Propagation d'une erreur de type SQLException.
	 */
	@Override
	public void insertNouvelleVente(Article article, Categorie categorie, Retrait retrait, Enchere enchere) throws SQLException, BusinessException {
		/* Connection cnx = null;
        cnx = ConnectionProvider.getConnection();
        try
            {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt1 = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt1.setString(1, article.getNomArticle()); 	 
                pstmt1.setString(2, article.getDescription());		  
                pstmt1.setInputStream(3, article.getPhotoArticle()); // A reprendre
                pstmt1.setDate(4, article.getDateDebutEncheres()); // A reprendre.
                pstmt1.setDate(5, article.getDateFinEncheres()); 
                pstmt1.setDouble(6, article.getPrixInitial());		 
                pstmt1.setDouble(7, article.getPrixVente());
                pstmt1.setString(8, article.getUtilisateur()); // A reprendre.
                pstmt1.executeUpdate();
                ResultSet rs = pstmt1.getGeneratedKeys();
                if(rs.next())
                {
                    article.setNoArticle(rs.getInt(1));	// Reprendre
                }
                
                PreparedStatement pstmt2 = cnx.prepareStatement(INSERT_CATEGORIE);
                pstmt2.setInt(1, categorie.getNoCategorie());
                pstmt2.executeUpdate();
                
                PreparedStatement pstmt3 = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt3.setInt(1, retrait.getNoRetrait());
                pstmt3.setString(2, retrait.getRue());
                pstmt3.setString(3, retrait.getCodePostal());
                pstmt3.setString(4, retrait.getVille());
                pstmt3.setInt(5, article.getNoArticle()); // A recontrôler.
                pstmt3.executeUpdate();
            } catch (SQLException e) {
				cnx.rollback();
				throw new DALException("Insert Nouvelle vente failed - ", e);
			} finally {
				cnx.setAutoCommit(true);
				ConnectionProvider.seDeconnecter(cnx, pstmt1);
				ConnectionProvider.seDeconnecter(cnx, pstmt2);
				ConnectionProvider.seDeconnecter(cnx, pstmt3);
			}
			*/
	}
	
	
	
	
	/*
	 * Méthode affichant toutes les ventes.
	 * @throws SQLException et BusinessException propagent les Exceptions de ces types aux méthdodes qui appellent insertNouvelleVente().
	 */
	public List<VenteManager> selectAll() throws SQLException, BusinessException{
		return null;
	}
	












	
	
	
}












