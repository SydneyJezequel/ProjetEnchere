package fr.eni.projetenchere.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec les informations de l'utilisateur ne respectent pas les règles définies
	 */
	public static final int REGLE_UTILISATEUR_NULL_ERREUR = 20000;
	public static final int REGLE_UTILISATEUR_PSEUDO_ERREUR = 20001;
	public static final int REGLE_UTILISATEUR_NOM_ERREUR=20002;
	public static final int REGLE_UTILISATEUR_PRENOM_ERREUR=20003;
	public static final int REGLE_UTILISATEUR_EMAIL_ERREUR=20004;
	public static final int REGLE_UTILISATEUR_TELEPHONE_ERREUR=20005;
	public static final int REGLE_UTILISATEUR_RUE_ERREUR=20006;
	public static final int REGLE_UTILISATEUR_CODE_POSTAL_ERREUR=20007;
	public static final int REGLE_UTILISATEUR_VILLE_ERREUR=20008;
	public static final int REGLE_UTILISATEUR_MDP_ERREUR=20009;
	public static final int REGLE_UTILISATEUR_CREDIT_ERREUR=20011;
	public static final int REGLE_UTILISATEUR_CONFIRMATION_ERREUR=20010;
	public static final int VALIDATION_UTILISATEUR_ERREUR = 20012;
}
