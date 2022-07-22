package fr.eni.projetenchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Utilisateur;
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
		Utilisateur utilisateurBDD = UtilisateurManager.getInstance()
				.getUtilisateurById(utilisateur.getNoUtilisateur());
		int id = utilisateurBDD.getNoUtilisateur();
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String code_postal = null;
		String ville = null;
		String mp = null;
		if (utilisateur.getPseudo() == null) {
			pseudo = utilisateurBDD.getPseudo();
		}
		if (utilisateur.getNom() == null) {
			nom = utilisateurBDD.getNom();
		}
		if (utilisateur.getPrenom() == null) {
			prenom = utilisateurBDD.getPrenom();
		}
		if (utilisateur.getEmail() == null) {
			email = utilisateurBDD.getEmail();
		}
		if (utilisateur.getTelephone() == null) {
			telephone = utilisateurBDD.getTelephone();
		}
		if (utilisateur.getRue() == null) {
			rue = utilisateurBDD.getRue();
		}
		if (utilisateur.getCodePostal() == null) {
			code_postal = utilisateurBDD.getCodePostal();
		}
		if (utilisateur.getVille() == null) {
			ville = utilisateurBDD.getVille();
		}
		if (utilisateur.getMotDePasse() == null) {
			mp = utilisateurBDD.getMotDePasse();
		}
		utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mp);
		DAOFactory.getUtilisateurDAO().updateUtilisateur(utilisateur);
	}

	public void ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue,
			String cp, String ville, String mdp, int credit, boolean admin) throws BusinessException, SQLException {
		BusinessException businessException = new BusinessException();
		Utilisateur newUtilisateur = null;
		if (!businessException.hasErreurs()) {
			newUtilisateur = new Utilisateur();
			newUtilisateur.setPseudo(pseudo);
			newUtilisateur.setNom(nom);
			newUtilisateur.setPrenom(prenom);
			newUtilisateur.setEmail(email);
			newUtilisateur.setTelephone(tel);
			newUtilisateur.setRue(rue);
			newUtilisateur.setCodePostal(cp);
			newUtilisateur.setVille(ville);
			newUtilisateur.setMotDePasse(mdp);
			newUtilisateur.setCredit(credit);
			newUtilisateur.setAdministrateur(admin);
			DAOFactory.getUtilisateurDAO().ajouterUtilisateur(newUtilisateur);
			utilisateurs.add(newUtilisateur);
		} else {
			throw businessException;
		}	
	}


	/**
	 */
	/*
	 *
	 * @param pseudo
	 * @return
	 * @throws Exception
	 */
	public List<Integer> validerInscription(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String mdp) {
		List<Integer> listeCodesErreur = new ArrayList<>();
		// lecture pseudo
		if (pseudo == null || pseudo.trim().isEmpty() || pseudo.trim().length() < 4 || pseudo.trim().length() > 30 || !pseudo.trim().matches("^[a-zA-Z0-9]*$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_PSEUDO_ERREUR);
		}
		if (nom == null || nom.trim().isEmpty() || nom.trim().length() > 30 || !nom.trim().matches("^[a-zA-Z0-9]*$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_NOM_ERREUR);
		}
		if (prenom == null || prenom.trim().isEmpty() || prenom.trim().length() > 30
				|| !prenom.trim().matches("^[a-zA-Z0-9]*$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_PRENOM_ERREUR);
		}
		if (email == null || email.trim().isEmpty() || email.trim().length() > 50
				|| !email.trim().matches("^(.+)@(.+)$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_EMAIL_ERREUR);
		}
		if (telephone == null || telephone.trim().isEmpty() || telephone.trim().length() > 30
				|| !telephone.trim().matches("^\\d{10}$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_TELEPHONE_ERREUR);
		}
		if (rue == null || rue.trim().isEmpty() || rue.trim().length() > 30 || !rue.trim().matches("^[a-zA-Z0-9]*$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_RUE_ERREUR);
		}
		if (codePostal == null || codePostal.trim().isEmpty() || codePostal.trim().length() > 5
				|| !codePostal.trim().matches("^\\d{5}$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_CODE_POSTAL_ERREUR);
		}
		if (ville == null || ville.trim().isEmpty() || ville.trim().length() > 50
				|| !ville.trim().matches("^[a-zA-Z0-9]*$")) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_VILLE_ERREUR);
		}
		// ||
		// !mdp.trim().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$")
		if (mdp == null || mdp.trim().isEmpty() || mdp.trim().length() > 30) {
			listeCodesErreur.add(CodesResultatBLL.FORMAT_UTILISATEUR_MDP_ERREUR);
		}
//       // Vérifie si le pseudo n'existe pas parmi les utilisateurs
//       if(utilisateurs.contains(pseudo.trim())) {
//           listeCodesErreur.add(CodesResultatBLL.UTILISATEUR_PSEUDO_UNIQUE_ERREUR);
//       }
//       // Vérifie si le nom n'existe pas parmi les utilisateurs
//       if(utilisateurs.contains(nom.trim())) {
//           listeCodesErreur.add(CodesResultatBLL.UTILISATEUR_NOM_UNIQUE_ERREUR);
//       }
		return listeCodesErreur;
	}

}
