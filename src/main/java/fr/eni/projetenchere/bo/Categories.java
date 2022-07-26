package fr.eni.projetenchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categories {

	
	private static final long serialVersionUID = 1L;
	
	
	
	// Attributs :
	private int noCategorie;
	private String libelle;

	
	
	// Constructeurs :
	public Categories() {}
	
	public Categories(String libelle) {
		this();
		setNoCategorie(noCategorie);
		setLibelle(libelle);
	}
	
	public Categories(int noCategorie, String libelle) {
		this();
		setNoCategorie(noCategorie);
		setLibelle(libelle);
	}
	
	
	
	// Getters & Setters :
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	// Autres méthode :
	public String toString() {
		return "Categorie [numéro noCategorie =" + getNoCategorie() + ", libelle=" + getLibelle() + "]";
	}




	
	
	
}
