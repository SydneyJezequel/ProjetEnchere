package fr.eni.projetenchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;

public class UtilisateurManager {

	// Attribut :
	private static UtilisateurManager instance;
	private List<Utilisateur> utilisateurs = new ArrayList<>();

	// Constructeur :
	private UtilisateurManager() throws SQLException {
		utilisateurs = DAOFactory.getUtilisateurDAO().selectAll();
	}

	/**
	 * Méthode de type Singleton.
	 * 
	 * @return Une Instance de la classe UtilisateurManager.
	 * @throws SQLException
	 * @throws Exception
	 */
	public static UtilisateurManager getInstance() throws SQLException {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	/*-------------------------------- Méthodes --------------------------------*/

	/**
	 * Méthode permettant de sélectionner un Utilisateur par son Identifiant.
	 * 
	 * @return Renvoie l'Utilisateur.
	 * @Etapes Appelle la méthode selectUtilisateurById() de la DAL.
	 * @throws Exception : Les exceptions sont propagées depuis la classe
	 *                   UtilisateurDAOJdbcImpl.
	 */
	public Utilisateur getUtilisateurById(int id) throws SQLException {
		return DAOFactory.getUtilisateurDAO().selectUtilisateurById(id);
	}

	/**
	 * Méthode permettant de rechercher par pseudo et de contrôler le mot de passe.
	 * 
	 * @param pseudo et mot de passe de l'utilisateur.
	 * @return Renvoie un booléen.
	 * @Etapes Récupère la saisie utilisateur, réalise les contrôle sur cette saisie
	 *         à l'aide de la méthode getUtilisateurByPseudo().
	 * @throws Exception : Les exceptions sont propagées depuis la classe
	 *                   UtilisateurDAOJdbcImpl.
	 */
	public boolean ControleDeConnexion(String pseudo, String mp) throws Exception {
		boolean ok = false;
		Utilisateur utilisateur = instance.getUtilisateurByPseudo(pseudo);
		if (utilisateur != null) {
			if (utilisateur.getPseudo().equals(pseudo)) {
				if (utilisateur.getMotDePasse().equals(mp)) {
					ok = true;
				}
			}
		}
		return ok;
	}

	/**
	 * Méthode sélectionnant un Utilisateur selon son pseudo.
	 * 
	 * @param pseudo de l'utilisateur.
	 * @return Renvoie l'utilisateur.
	 * @Etapes Appelle la méthode getUtilisateurByPseudo() de la DAL.
	 * @throws SQLException : Les exceptions sont propagées depuis la classe
	 *                      UtilisateurDAOJdbcImpl.
	 */
	public Utilisateur getUtilisateurByPseudo(String pseudo) throws SQLException {
		return DAOFactory.getUtilisateurDAO().selectUtilisateurByPseudo(pseudo);
	}

	/**
	 * Méthode permettant de vérifier si le mot de passe renseigné par l'utilisateur
	 * est identique au mot de passe en BDD.
	 * 
	 * @param pseudo et mot de passe de l'utilisateur.
	 * @return Renvoie true si le mdp renseigné par l'utilisateur est identique au
	 *         mdp en BDD.
	 * @Etapes Appelle la méthode de la DAL selectUtilisateurByPseudo(pseudo) pour
	 *         récupérer l'utilisateur en BDD, Compare le mot de passe fournit avec
	 *         le mot de passe en BDD, Renvoie un booléen.
	 * @throws SQLException : Les exceptions sont propagées depuis la classe
	 *                      UtilisateurDAOJdbcImpl.
	 */
	public boolean VerifMdpActuel(String pseudo, String mpactuel) throws SQLException {
		boolean identique = false;
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectUtilisateurByPseudo(pseudo);
		String mpBDD = utilisateur.getMotDePasse();
		if (mpactuel == mpBDD) {
			identique = true;
		}
		return identique;
	}

	/**
	 * Méthode mettant à jour un Utilisateur en BDD.
	 * 
	 * @param instance de type Utilisateur.
	 * @Etapes Récupère la saisie utilisateur, contrôle les valeurs créé une
	 *         instance de type Utilisateur, appelle la méthode updateUtilisateur()
	 *         de la DAL pour mettre à jour les données.
	 * @throws Exception : Les exceptions sont propagées depuis la classe
	 *                   UtilisateurDAOJdbcImpl.
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws Exception {
		Utilisateur utilisateurBDD = UtilisateurManager.getInstance().getUtilisateurById(utilisateur.getNoUtilisateur());
		/* Afficher les valeurs par défaut - Debut - */
		HttpServletRequest request=null;
		HttpSession session = request.getSession(true);
		session.setAttribute("utilisateur", utilisateurBDD);
		/* Afficher les valeurs par défaut - Fin - */
		int id = utilisateurBDD.getNoUtilisateur();
		String pseudo = utilisateur.getPseudo();
		String nom = utilisateur.getNom();
		String prenom = utilisateur.getPrenom();
		String email = utilisateur.getEmail();
		String telephone = utilisateur.getTelephone();
		String rue = utilisateur.getRue();
		String code_postal = utilisateur.getCodePostal();
		String ville = utilisateur.getVille();
		String mp = utilisateur.getMotDePasse();
		if (utilisateur.getPseudo().isEmpty()) {
			pseudo = utilisateurBDD.getPseudo();
		}
		if (utilisateur.getNom().isEmpty()) {
			nom = utilisateurBDD.getNom();
		}
		if (utilisateur.getPrenom().isEmpty()) {
			prenom = utilisateurBDD.getPrenom();
		}
		if (utilisateur.getEmail().isEmpty()) {
			email = utilisateurBDD.getEmail();
		}
		if (utilisateur.getTelephone().isEmpty()) {
			telephone = utilisateurBDD.getTelephone();
		}
		if (utilisateur.getRue().isEmpty()) {
			rue = utilisateurBDD.getRue();
		}
		if (utilisateur.getCodePostal().isEmpty()) {
			code_postal = utilisateurBDD.getCodePostal();
		}
		if (utilisateur.getVille().isEmpty()) {
			ville = utilisateurBDD.getVille();
		}
		if (utilisateur.getMotDePasse().isEmpty()) {
			mp = utilisateurBDD.getMotDePasse();
		}
		utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mp);
		DAOFactory.getUtilisateurDAO().updateUtilisateur(utilisateur);
	}	

	
	
	
	
	/*
	 *
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public void ajoutUtilisateur(Utilisateur newUtilisateur, String confirmation) throws BusinessException, DALException, SQLException, BLLException {
//		if (utilisateurs.contains(newUtilisateur)) {
//			throw new BLLException("Utilisateur déjà existant.");
//		}
		BusinessException businessException = new BusinessException();
		this.validerUtilisateur(newUtilisateur, confirmation, businessException);
				
		if(!businessException.hasErreurs())
		{
			DAOFactory.getUtilisateurDAO().insertUtilisateur(newUtilisateur);
		}
		else
		{
			businessException.ajouterErreur(CodesResultatBLL.VALIDATION_UTILISATEUR_ERREUR);
			throw businessException;
		}
	}

	
	
	
	
	
	
	
	/*
	 *
	 * @param 
	 * @return
	 * @throws Exception
	 */
		public void validerUtilisateur(Utilisateur u, String confirmation, BusinessException businessException) throws BusinessException {
		if (u == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NULL_ERREUR);
		}
		// Les attributs des utilisateurs sont obligatoires sauf pour le téléphone
		if (u.getPseudo() == null || u.getPseudo().isBlank() || u.getPseudo().trim().length() < 4 || u.getPseudo().trim().length() > 30 || !u.getPseudo().trim().matches("^[a-zA-Z0-9]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
		}
		if (u.getNom() == null || u.getNom().isBlank() || u.getNom().trim().length() > 30 || !u.getNom().trim().matches("^[a-zA-Z]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_ERREUR);
		}
		if (u.getPrenom() == null || u.getPrenom().isBlank() || u.getPrenom().trim().length() > 30 || !u.getPrenom().trim().matches("^[a-zA-Z]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_ERREUR);
		}
		if (u.getEmail() == null || u.getEmail().isBlank() || u.getEmail().trim().length() > 30 || !u.getEmail().trim().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_ERREUR);
		}
		if (u.getTelephone() == null || u.getTelephone().isBlank() || u.getTelephone().trim().length() > 15 || !u.getTelephone().trim().matches("^\\d{10}$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_TELEPHONE_ERREUR);
		}
		if (u.getRue() == null || u.getRue().isBlank() || u.getRue().trim().length() > 30 || !u.getRue().trim().matches("^[a-zA-Z0-9]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_RUE_ERREUR);
		}
		if (u.getCodePostal() == null || u.getCodePostal().isBlank() || u.getCodePostal().trim().length() > 10 || !u.getCodePostal().trim().matches("^\\d{5}$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CODE_POSTAL_ERREUR);
		}
		if (u.getVille() == null || u.getVille().isBlank() || u.getVille().trim().length() > 50 || !u.getVille().trim().matches("^[a-zA-Z]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_VILLE_ERREUR);
		}
		// !mdp.trim().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$")
		if (u.getMotDePasse() == null || u.getMotDePasse().isBlank() || u.getMotDePasse().trim().length() > 30 || !u.getMotDePasse().trim().matches("^[a-zA-Z0-9@$!%*?&]*$")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MDP_ERREUR);
		}
		if (u.getCredit() == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CREDIT_ERREUR);
		}
		if (confirmation==null || confirmation.isBlank() || !u.getMotDePasse().equals(confirmation)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CONFIRMATION_ERREUR);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
