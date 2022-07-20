package fr.eni.projetenchere.bll;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DAOFactory;



public class  UtilisateurManager {


	
	// Attribut :
    private static UtilisateurManager  instance;
    private String coincoin;
   
    
    // Constructeur :
    private UtilisateurManager() {}

    
    
    // Singleton :
    public static UtilisateurManager getInstance() {
        if(instance == null) {
             instance = new UtilisateurManager();
        }
         return instance;
    }

    
    
    // Méthodes :
    public Utilisateur getUtilisateurById(int id){
        return DAOFactory.getUtilisateurDAO().selectUtilisateurById(id);
	}
    
    
    
    // Connexion :
    public boolean Connexion(String pseudo, String mp) throws Exception {
    	boolean ok = false;
    	Utilisateur utilisateur = instance.getUtilisateurByPseudo(pseudo);
		if (utilisateur != null) {
			if(utilisateur.getPseudo().equals(pseudo)){
				if(utilisateur.getMotDePasse().equals(mp)){
					ok = true;
				}
			}
		}	
    	return ok;
    }	
    
    
    
    // Récupérer un Utilisateur par id de connexion :
    public Utilisateur getUtilisateurByPseudo(String pseudo) throws Exception{
        return DAOFactory.getUtilisateurDAO().selectUtilisateurByPseudo(pseudo);
	}
    	

    // Mettre à jour l'utilisateur
    
    
    
    
    
}
	
	
	


