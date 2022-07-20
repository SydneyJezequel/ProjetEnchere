package fr.eni.projetenchere.bo;

import java.io.Serializable;

/**
 * Javabean permettant d'instancier un objet de type Utilisateur.
 * @author sjezequel
 *
 */
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attributs d'un objet de type Utilisateur.
	 */
	private int noUtilisateur;
	private String pseudo;
	private String nom; 
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville; 
	private String motDePasse;
	private int credit;
	private boolean administrateur;
	
	
	/**
	 * Constructeurs :
	 * Premier constructeur : Constructeur par défaut.
	 * Deuxième constructeur : Constructeur pour insérer un Utilisateur en BDD.
	 * Troisième constructeur : Constructeur pour extraire un Utilisateur de la BDD.
	 */
	public Utilisateur() {}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
	}
	
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		this(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		setNoUtilisateur(noUtilisateur);
	}
	
	
	
	//Autre méthode :
	public String toString() {
		return "Utilisateur [noUtilisateur=" + getNoUtilisateur() + ", pseudo=" + getPseudo() + ", nom=" + getNom() + ", prenom="
				+ getPrenom() + ", email=" + getEmail() + ", telephone=" + getTelephone() + ", rue=" + getRue() + ", codePostal="
				+ getCodePostal() + ", ville=" + getVille() + ", motDePasse=" + getMotDePasse() + ", credit=" + getCredit()
				+ ", administrateur=" + isAdministrateur() + "]";
	}
	
	
	
	
	
	// Getters & Setters :
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	

}
