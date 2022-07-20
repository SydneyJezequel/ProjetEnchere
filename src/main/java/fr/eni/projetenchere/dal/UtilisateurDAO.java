package fr.eni.projetenchere.dal;

import java.sql.SQLException;

import fr.eni.projetenchere.bo.Utilisateur;


/**
 * 
 * 
 * @author sjezequel
 *
 */
public interface UtilisateurDAO {

	/**
	 * 
	 * @param id : Identifiant Utilisateur.
	 * @return Une instance de type Utilisateur.
	 * @throws SQLException propage l'exception SQL aux méthdodes qui appellent cette méthode.
	 */
	public Utilisateur selectUtilisateurById(int id) throws SQLException;

	/**
	 * 
	 * @param pseudo : Pseudo Utilisateur.
	 * @return Une instance de type Utilisateur.
	 * @throws SQLException propage l'exception SQL aux méthdodes qui appellent cette méthode.
	 */
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws SQLException;
	
	/**
	 * 
	 * @param utilisateur est une instance de type Utilisateur.
	 * @throws SQLException propage l'exception SQL aux méthdodes qui appellent cette méthode.
	 */
	public void update(Utilisateur utilisateur) throws SQLException;
	

}
