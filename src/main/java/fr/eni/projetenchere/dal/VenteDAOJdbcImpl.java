package fr.eni.projetenchere.dal;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;

public class VenteDAOJdbcImpl implements VenteDAO {

	// Constructeur
	public VenteDAOJdbcImpl() {
	}

	// Requêtes paramétrées :
	private static final String SELECT_ALL_CATEGORIE = "SELECT libelle FROM Categories";
	private static final String INSERT_ARTICLE = "INSERT INTO Articles (nom_article, description, photo_article, prix_initial, prix_vente, date_debut_encheres, date_fin_encheres, no_categorie, no_utilisateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_RETRAIT = "INSERT INTO Retraits (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";
	private static final String INSERT_ENCHERE = "INSERT INTO Encheres (date_enchere, montant_enchere, no_utilisateur, no_article) VALUES (?, ?, ?, ?)";

	/*-------------------------------------- METHODES -------------------------------------- */

	/**
	 * Méthode sélectionnant un Utilisateur par son Identifiant.
	 * 
	 * @param : Objets Article, Retrait, Enchere.
	 * @Etapes : La méthode se connecte à la BDD, exécute 3 requêtes paramétrées
	 * pour insérer chaque objet passé en paramètre (Article, Retrait, Enchère),
	 * elle récupère les numéro de lignes générées et les affectent aux objets,
	 * elle clot la connexion.
	 * @throws SQLException : Propagation d'une erreur de type SQLException.
	 * @throws DALException : Propagation d'une erreur de type SQLException.
	 * @throws DALException : Propagation d'une erreur de type BusinessException.
	 */
	@Override
	public void insertNouvelleVente(Article article, Retrait retrait, Enchere enchere) throws SQLException, BusinessException, DALException {
		Connection cnx = null;
		cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try {
			cnx.setAutoCommit(false);
			// Insertion article :
			pstmt1 = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, article.getNomArticle());
			pstmt1.setString(2, article.getDescription());
			pstmt1.setBinaryStream(3, article.getPhotoArticle()); // Contrôler : Si cette partie du code s'exécute correctement ?
			pstmt1.setInt(4, article.getPrixInitial());
			pstmt1.setInt(5, article.getPrixVente());
			pstmt1.setDate(6, article.getDateDebutEncheres());
			pstmt1.setDate(7, article.getDateFinEncheres());
			pstmt1.setInt(8, article.getCategorie().getNoCategorie());
			pstmt1.setInt(9, article.getUtilisateur().getNoUtilisateur()); 
			pstmt1.executeUpdate();
			ResultSet rs1 = pstmt1.getGeneratedKeys();
			if (rs1.next()) {
				article.setNoArticle(rs1.getInt(1));
			}
			// Insertion retrait :
			pstmt2 = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt2.setString(1, retrait.getRue());
			pstmt2.setString(2, retrait.getCodePostal());
			pstmt2.setString(3, retrait.getVille());
			pstmt2.setInt(4, article.getNoArticle());
			pstmt2.executeUpdate();
			ResultSet rs2 = pstmt2.getGeneratedKeys();
			if (rs2.next()) {
				retrait.setNoRetrait(rs2.getInt(1));
			}
			// Insertion enchère :
			pstmt3 = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt3.setDate(1, enchere.getDateEnchere());
			pstmt3.setDouble(2, enchere.getMontantEnchere());
			pstmt3.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
			pstmt3.setInt(4, enchere.getArticleVendu().getNoArticle());
			pstmt3.executeUpdate();
			ResultSet rs3 = pstmt3.getGeneratedKeys();
			if (rs3.next()) {
				enchere.setNoEnchere(rs3.getInt(1));
			}
		} catch (SQLException e) {
			cnx.rollback();
			throw new BusinessException();
		} finally {
			cnx.setAutoCommit(true);
			ConnectionProvider.seDeconnecter(cnx, pstmt1);
			ConnectionProvider.seDeconnecter(cnx, pstmt2);
			ConnectionProvider.seDeconnecter(cnx, pstmt3);
		}
	}

	
	
	/**
	 * Méthode affichant toutes les catégorie. Elle est utilisée pour le menu déroulant de la JSP "NouvelleVente".
	 * @Etapes : Cette méthode se connecte à la BDD, Elle exécute la requête paramétrée "SELECT_ALL_CATEGORIE".
	 * Elle récupère chaque libellé pour les stocker dans un tableau. Elle renvoie ce tableau.
	 * @throws SQLException et BusinessException propagent les Exceptions de ces
	 * types aux méthdodes qui appellent insertNouvelleVente().
	 */
	public List<Categorie> selectAllCategories() throws SQLException, BusinessException {
		Categorie categorie;
		List<Categorie> listeCate = new ArrayList();
		String libelle;
		Connection cnx1 = null;
		PreparedStatement pstmt = null;
		cnx1 = ConnectionProvider.getConnection();
		try {
			pstmt = cnx1.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				libelle = rs.getString("libelle");
				categorie = new Categorie(libelle);
				listeCate.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCate;
	}

	
	
	/**
	 * Méthode affichant toutes les ventes.
	 * 
	 * @throws SQLException et BusinessException propagent les Exceptions de ces
	 * types aux méthdodes qui appellent insertNouvelleVente().
	 */

	/*
	 * public List<VenteManager> selectAll() throws SQLException, BusinessException{
	 * return null; }
	 */

}
