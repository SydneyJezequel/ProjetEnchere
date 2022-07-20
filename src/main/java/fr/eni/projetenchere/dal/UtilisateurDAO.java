package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Utilisateur;

public interface UtilisateurDAO {

	
	public Utilisateur selectUtilisateurById(int id);

	public Utilisateur selectUtilisateurByPseudo(String pseudo);
	
	

}
