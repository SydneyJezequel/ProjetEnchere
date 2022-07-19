package fr.eni.projetenchere.bll;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DAOFactory;



public class UtilisateurManager {


	// Attribut :
    private static UtilisateurManager instance;

   
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

    
    
}
	
	
	

