package fr.eni.projetenchere.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	
	/**
	 * Echec général quand tentative d'ajouter un utilisateur null
	 */
	public static final int CONNEXION_BDD_ECHEC=10000;
	/**
	 * Echec général quand tentative d'ajouter un utilisateur null
	 */
	public static final int INSERT_UTILISATEUR_NULL=10001;
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_UTILISATEUR_ECHEC=10002;
	/**
	 * Echec de la lecture des utilisateurs
	 */
	public static final int LECTURE_UTILISATEURS_ECHEC = 10003;
	/**
	 * Echec de la lecture d'un utilisateur
	 */
	public static final int LECTURE_UTILISATEUR_ECHEC = 10004;
	/**
	 * utilisateur inexistant
	 */
	public static final int LECTURE_UTILISATEUR_INEXISTANT = 10005;
	/**
	 * Erreur à la suppression d'un utilisateur
	 */
	public static final int SUPPRESSION_UTILISATEUR_ERREUR = 10006;
	/**
	 * Erreur à la lecture d'une enchere en cours
	 */
	public static final int LECTURE_ENCHERES_EN_COURS_ECHEC = 10007;
	/**
	 * Erreur à la lecture des catégories
	 */
	public static final int LECTURE_CATEGORIES_ECHEC = 10008;
	/**
	 * Erreur à la lecture des catégories
	 */
	public static final int LECTURE_ENCHERES_FILTRE_ECHEC = 10009;
	/**
	 * Erreur à la lecture des catégories
	 */
	public static final int LECTURE_ENCHERES_CATEGORIE_ECHEC = 10010;
	/**
	 * Erreur à la lecture des catégories
	 */
	public static final int LECTURE_ENCHERES_FILTRE_ET_CATEGORIE_ECHEC = 10011;
}












