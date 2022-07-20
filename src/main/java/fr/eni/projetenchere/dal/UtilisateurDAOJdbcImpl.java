package fr.eni.projetenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.projetenchere.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl  implements UtilisateurDAO {
	
	
	
	// Requêtes paramétrées :
	private static final String  SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String  SELECT_BY_NAME = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
	private static final String UPDATEUTILISATEURS = "UPDATE UTILISATEURS SET pseudo = ? , nom= ? , prenom = ? , email = ? , telephone = ? , rue = ? , code_postal = ? , ville = ? , mot_de_passe = ? , credit = ? , administrateur = ? WHERE no_utilisateur = ?"; 
	
	// Constructeurs :
	public UtilisateurDAOJdbcImpl() {}
	
	
	
	
	
	/*-------------------------------------- METHODES -------------------------------------- */
	
	// SELECTBYID :
	public Utilisateur selectUtilisateurById(int id) {
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = map(rs);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	// SELECTBYNAME :
	public Utilisateur selectUtilisateurByPseudo(String pseudo) {
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NAME);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = map(rs);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	
	
	// UPDATE :
	public void update(Utilisateur utilisateur) throws Exception {

		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATEUTILISATEURS);
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
				pstmt.close();
				cnx.commit();
			} catch (SQLException e) {
				throw new Exception("Update Utilisateur failed - " + e);
				cnx.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
}
	
	
	
	
	


	// Builder :
	private Utilisateur map(ResultSet rs) throws SQLException {
		Utilisateur utilisateur=null;
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
			int credit = rs.getInt	("credit");
			boolean admin = rs.getBoolean("administrateur");
			utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, tel, rue, code, ville, mp, credit, admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	
	
	
	
	
	
	

}
