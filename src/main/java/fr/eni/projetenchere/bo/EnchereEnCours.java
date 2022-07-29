package fr.eni.projetenchere.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class EnchereEnCours implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String pseudo;
	private String nomArticle;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private Categorie categorie;
	
	//Constructeurs
	public EnchereEnCours() {}
	
	
	public EnchereEnCours(String pseudo, String nomArticle, LocalDate dateFinEncheres, int prixInitial) {
	this();
	setPseudo(pseudo);
	setNomArticle(nomArticle);
	setDateFinEncheres(dateFinEncheres);
	setPrixInitial(prixInitial);
	}
	
	//Autres méhodes
	@Override
	public String toString() {
		return "EnchereEnCours [pseudo=" + pseudo + ", nomArticle=" + nomArticle + ", dateFinEncheres="
				+ dateFinEncheres + ", prixInitial=" + prixInitial + ", categorie=" + categorie + "]";
	}

	//Getters et Setters
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
