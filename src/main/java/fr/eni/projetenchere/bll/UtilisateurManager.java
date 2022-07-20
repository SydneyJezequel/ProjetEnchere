package fr.eni.projetenchere.bll;

import java.sql.SQLException;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DAOFactory;



public class  UtilisateurManager {


	
	// Attribut :
    private static UtilisateurManager  instance;
   

    // Constructeur :
    private UtilisateurManager() {}

    
    /**
     * Méthode de type Singleton.
     * @return Une Instance de la classe UtilisateurManager.
     */
    public static UtilisateurManager getInstance() {
        if(instance == null) {
             instance = new UtilisateurManager();
        }
         return instance;
    }

    
    
    /*-------------------------------- Méthodes --------------------------------*/
    /**
     * 
     * @param pseudo
     * @return
     * @throws Exception
     */
    public Utilisateur getUtilisateurById(int id) throws SQLException{
        return DAOFactory.getUtilisateurDAO().selectUtilisateurById(id);
	}
    
    
    
    /**
     * 
     * @param pseudo
     * @return
     * @throws Exception
     */
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
    
    
    
    /**
     * 
     * @param pseudo
     * @return
     * @throws Exception
     */
    public Utilisateur getUtilisateurByPseudo(String pseudo) throws Exception{
        return DAOFactory.getUtilisateurDAO().selectUtilisateurByPseudo(pseudo);
	}
    	

    /**
     * 
     * @param pseudo
     * @return
     * @throws Exception
     */
    
    
    
    
    
}
	
	
	


