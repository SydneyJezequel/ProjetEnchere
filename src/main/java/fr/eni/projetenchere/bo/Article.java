package fr.eni.projetenchere.bo;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;



public class Article implements Serializable{

	private static final long serialVersionUID = 1L;

	
	
	// Attributs :
	private int noArticle;
	private String nomArticle;
	private String description;
	private InputStream photoArticle; 
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	
	
	
	// Constructeurs :
	public Article() {}
	
	public Article(String nomArticle, String description, InputStream photoArticle, Date dateDebutEncheres, Date dateFinEncheres, int prixInitial, Utilisateur utilisateur, Categorie categorie) {
		this();
		setNomArticle(nomArticle);
		setDescription(description);
		setPhotoArticle(photoArticle);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setUtilisateur(utilisateur);
		setCategorie(categorie);
	}

	public Article(int noArticle, String nomArticle, String description, InputStream photoArticle, Date dateDebutEncheres, Date dateFinEncheres, int prixInitial, Utilisateur utilisateur, Categorie categorie) {
		this(nomArticle, description, photoArticle, dateDebutEncheres, dateFinEncheres, prixInitial, utilisateur, categorie);
		setNoArticle(noArticle);
	}
	
	
	// Getters & Setters :
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public InputStream getPhotoArticle() {
		return photoArticle;
	}

	public void setPhotoArticle(InputStream photoArticle) {
		this.photoArticle = photoArticle;
	}

	
	
	
	// Autre méthode :
	public String toString() {
		return "Article vendu [Numéro Article=" + getNoArticle() + ", Nom Article=" + getNomArticle() + ", Description=" + getDescription()
				+ ", photo Article=" + getPhotoArticle() + ", Date début enchère=" + getDateDebutEncheres() + ", Date fin enchère=" + getDateFinEncheres()
				+ ", prix initial=" + getPrixInitial() + ", prix vente=" + getPrixVente() + ", Utilisateur=" + getUtilisateur() + ", Catégorie="
				+ getCategorie() + "]";
	}
		
		
		
	

	
	
	
}
