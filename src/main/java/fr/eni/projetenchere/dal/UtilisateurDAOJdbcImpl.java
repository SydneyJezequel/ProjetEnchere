package fr.eni.projetenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	
	
	// Requêtes paramétrées :
	private static final String SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_BY_NAME = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo = ?";
	private static final String UPDATEUTILISATEURS = "UPDATE UTILISATEURS SET pseudo = ? , nom= ? , prenom = ? , email = ? , telephone = ? , rue = ? , code_postal = ? , ville = ? , mot_de_passe = ? WHERE no_utilisateur = ?";

	
	
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
	public Utilisateur selectUtilisateurById(int id) throws SQLException {
		Utilisateur utilisateur = null;
		Connection cnx = null;
		PreparedStatement pstmt = null;
		cnx = ConnectionProvider.getConnection();
		try {
			pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				utilisateur = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	
	
	/**
	 * Méthode sélectionnant qui renvoie un Utilisateur identifié par son attribut
	 * Pseudo.
	 * 
	 * @param Pseudo de l'utilisateur.
	 * @Etapes La méthode se connecte à la BDD, exécute la requête paramétrée
	 *         SELECT_BY_NAME, récupère les données sélectionnée en s'appuyant sur
	 *         la méthode "map(rs)".
	 * @throws SQLException : Propagation d'une erreur de type SQLException.
	 */
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws SQLException {
		Utilisateur utilisateur = null;
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NAME);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				utilisateur = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	
	
	/**
	 * Méthode modifiant les attributs de l'utilisateur dans la BDD.
	 * 
	 * @Param Instance de type Utilisateur.
	 * @Etapes Connexion, prépare la requête paramétré, exécuter la requête
	 *         paramétré.
	 * @throws Exception : propagée sur les couches supérieures.
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException, DALException {
			Connection cnx = null;
			PreparedStatement pstmt = null;
		
			cnx = ConnectionProvider.getConnection();
			try {
				cnx.setAutoCommit(false);
				pstmt = cnx.prepareStatement(UPDATEUTILISATEURS);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, utilisateur.getNoUtilisateur());
				pstmt.executeUpdate();
				cnx.commit();
			} catch (SQLException e) {
				cnx.rollback();
				throw new DALException("Update Utilisateur failed - ", e);
			} finally {
				cnx.setAutoCommit(true);
				ConnectionProvider.seDeconnecter(cnx, pstmt);
			}
	}

	
	
	/**
	 * Méthode permettant de créer un objet de type Utilisateur à partir de la BDD.
	 * 
	 * @param rs récupère les données extraites de la BDD.
	 * @return l'Utilisateur généré.
	 * @throws SQLException permet de propager l'erreur SQL aux méthodes qui appelle
	 *                      cette méthodes.
	 */
	private Utilisateur map(ResultSet rs) throws SQLException {
		Utilisateur utilisateur = null;
		try {
			int id = rs.getInt("no_utilisateur");
			String pseudo = rs.getString("pseudo");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String tel = rs.getString("telephone");
			String rue = rs.getString("rue");
			String code = rs.getString("code_postal");
			String ville = rs.getString("ville");
			String mp = rs.getString("mot_de_passe");
			int credit = rs.getInt("credit");
			boolean admin = rs.getBoolean("administrateur");
			utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, tel, rue, code, ville, mp, credit, admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	
	
	/**
	 * Méthode permettant de sélectionner tous les Utilisateurs de la BDD.
	 * 
	 * @param
	 * @return la liste de tous les Utilisateurs.
	 * @throws SQLException permet de propager l'erreur SQL aux méthodes qui appelle
	 *                      cette méthodes.
	 */
	@Override
	public List<Utilisateur> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException, SQLException {
        if(utilisateur==null)
        {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }
        Connection cnx = null;
        cnx = ConnectionProvider.getConnection();
        try
        {
            try
            {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, utilisateur.getPseudo());
                pstmt.setString(2, utilisateur.getNom());
                pstmt.setString(3, utilisateur.getPrenom());
                pstmt.setString(4, utilisateur.getEmail());
                pstmt.setString(5, utilisateur.getTelephone());
                pstmt.setString(6, utilisateur.getRue());
                pstmt.setString(7, utilisateur.getCodePostal());
                pstmt.setString(8, utilisateur.getVille());
                pstmt.setString(9, utilisateur.getMotDePasse());
                pstmt.setInt(10, utilisateur.getCredit());
                pstmt.setBoolean(11, utilisateur.isAdministrateur());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next())
                {
                    utilisateur.setNoUtilisateur(rs.getInt(1));
                }
                System.out.println("Utilisateur enregistré");
                rs.close();
                pstmt.close();
                cnx.commit();

            }
            catch(SQLException e)
            {
                System.out.println("erreur ajout utilisateur");
                e.printStackTrace();
                cnx.rollback();
                throw e;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;

        }
	
	

}
