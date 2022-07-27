package fr.eni.projetenchere.dal;

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
	private static final String SELECT_ALL_CATEGORIE = "SELECT no_categorie,libelle  FROM Categorie";
	private static final String INSERT_ARTICLE = "INSERT INTO Articles (nom_article, description, photo_article, prix_initial, prix_vente, date_debut_enchere, date_fin_enchere, no_categorie, no_utilisateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_RETRAIT = "INSERT INTO Retraits (rue, code_postal, ville, no_article) VALUES (?, ?, ?, ?)";
	private static final String INSERT_ENCHERE = "INSERT INTO Encheres (date_enchere, montant_enchere, no_utilisateur, no_article) VALUES (?, ?, ?, ?)";

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
	public void insertNouvelleVente(Article article, Retrait retrait, Enchere enchere)
			throws SQLException, BusinessException {
		Connection cnx = null;
		cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt1;
		PreparedStatement pstmt2;
		PreparedStatement pstmt3;
		try {
			cnx.setAutoCommit(false);
			// Insertion article :
			pstmt1 = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, article.getNomArticle());
			pstmt1.setString(2, article.getDescription());
			pstmt1.setInputStream(3, article.getPhotoArticle()); // A reprendre
			pstmt1.setDouble(4, article.getPrixInitial());
			pstmt1.setDouble(5, article.getPrixVente());
			pstmt1.setDate(6, article.getDateDebutEncheres()); // A reprendre.
			pstmt1.setDate(7, article.getDateFinEncheres());
			pstmt1.setInt(8, article.getCategorie().getNoCategorie());
			pstmt1.setInt(9, article.getUtilisateur().getNoUtilisateur()); // A reprendre.
			pstmt1.executeUpdate();
			ResultSet rs1 = pstmt1.getGeneratedKeys(); // Je récupère la clé générée.
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
			pstmt3.setInt(3, enchere.getNoUtilisateur());
			pstmt3.setInt(4, enchere.getNoArticle());
			pstmt3.executeUpdate();
			ResultSet rs3 = pstmt3.getGeneratedKeys();
			if (rs3.next()) {
				enchere.setNoEnchere(rs3.getInt(1));
			}
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Insert Nouvelle vente failed - ", e);
		} finally {
			cnx.setAutoCommit(true);
			ConnectionProvider.seDeconnecter(cnx, pstmt1);
			ConnectionProvider.seDeconnecter(cnx, pstmt2);
			ConnectionProvider.seDeconnecter(cnx, pstmt3);
		}
	}

	
	
	/*
	 * Méthode affichant toutes les catégorie. Elle est utilisée pour le menu
	 * déroulant de la JSP "NouvelleVente".
	 * 
	 * @throws SQLException et BusinessException propagent les Exceptions de ces
	 * types aux méthdodes qui appellent insertNouvelleVente().
	 */
	public List<Categorie> selectAllCategories() throws SQLException, BusinessException {
		Categorie categorie;
		List<Categorie> listeCate = new ArrayList();
		int noCategorie;
		String libelle;
		Connection cnx1 = null;
		PreparedStatement pstmt = null;
		cnx1 = ConnectionProvider.getConnection();
		try {
			pstmt = cnx1.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				noCategorie = rs.getInt("no_categorie");
				libelle = rs.getString("libelle");
				categorie = new Categories(noCategorie, libelle);
				listeCate.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCate;
	}

	/*
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
