package fr.eni.projetenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.projetenchere.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	
	
	// Requêtes paramétrées :
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	
	
	// Constructeurs :
	public UtilisateurDAOJdbcImpl() {}
	
	
	
	// Méthodes :
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




	private Utilisateur map(ResultSet rs) throws SQLException {
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

		return new Utilisateur(id, pseudo, nom, prenom, email, tel, rue, code, ville, mp, credit, admin);
	}

	
	
	
	
	
	
	

}
