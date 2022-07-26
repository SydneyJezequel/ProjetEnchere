package fr.eni.projetenchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * 
 * 
 * @author sjezequel
 *
 */


public interface UtilisateurDAO {

	/**
	 * Méthode sélectionnant un Utilisateur par son Identifiant.
	 * 
	 * @param id : Identifiant Utilisateur.
	 * @return Une instance de type Utilisateur.
	 * @throws SQLException propage l'exception SQL aux méthdodes qui appellent
	 *                      cette méthode.
	 */
	public Utilisateur selectUtilisateurById(int id) throws SQLException;

	/**
	 * Méthode sélectionnant qui renvoie un Utilisateur identifié par son attribut
	 * Pseudo.
	 * 
	 * @param pseudo : Pseudo Utilisateur.
	 * @return Une instance de type Utilisateur.
	 * @throws SQLException propage l'exception SQL aux méthdodes qui appellent
	 *                      cette méthode.
	 */
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws SQLException;

	/**
	 * Méthode mettant à jour un Utilisateur en BDD.
	 * 
	 * @param utilisateur est une instance de type Utilisateur.
	 * @throws Exception propage l'exception aux méthdodes qui appellent cette
	 *                   méthode.
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException, DALException;

	/*
	 * Méthode renvoyant tous les utilisateurs de la BDD.
	 * 
	 * @throws SQLException propage l'exception SQL aux méthdodes qui appellent
	 * cette méthode.
	 */
	public List<Utilisateur> selectAll() throws SQLException;

	

	/*
	 * 
	 * 
	 */
	public void insertUtilisateur(Utilisateur utilisateur) throws SQLException, BusinessException;
	
	/**
	 * SUPPRIMER UN PSEUDO UTILISATEUR
	 * @param pseudo
	 * @throws DALException
	 */
	public static void supprimer(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		
	}
		
	
	
	
}
