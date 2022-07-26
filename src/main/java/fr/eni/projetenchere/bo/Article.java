package fr.eni.projetenchere.bo;

import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;



public class Article implements Serializable{

	private static final long serialVersionUID = 1L;

	// Attributs :
	private int noArticle;
	private String nomArticle;
	private String description;
	private InputStream photoArticle; 
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private double prixInitial;
	private double prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	
	
	
	// Constructeurs :
	public Article() {}
	
	public Article(String nomArticle, String description, InputStream photoArticle, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, double prixInitial, Utilisateur utilisateur, Categorie categorie) {
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

	public Article(int noArticle, String nomArticle, String description, InputStream photoArticle, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, double prixInitial, Utilisateur utilisateur, Categorie categorie) {
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

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public double getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(double prixInitial) {
		this.prixInitial = prixInitial;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
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
