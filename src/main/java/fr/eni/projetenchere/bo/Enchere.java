package fr.eni.projetenchere.bo;

import java.io.Serializable;



public class Enchere {

	private static final long serialVersionUID = 1L;
	
	
	
	// Attributs :
	private int noRetrait;
	private String rue;
	private String codePostal;
	private String ville;
	private int noArticle;
	private Article article;
	private Utilisateur utilisateur;
	
	
	
	// Constructeurs :
	public Enchere() {}
	
	public Enchere(String rue, String codePostal, String ville, Article article, Utilisateur utilisateur) {
		this();
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setArticle(article);
		setUtilisateur(utilisateur);
	}
	
	public Enchere(int noRetrait, String rue, String codePostal, String ville,  Article article, Utilisateur utilisateur) {
		this(rue, codePostal, ville, article, utilisateur);
		setNoRetrait(noRetrait);
	}
	
	
	
	// Getters & Setters :
	public int getNoRetrait() {
		return noRetrait;
	}

	public void setNoRetrait(int noRetrait) {
		this.noRetrait = noRetrait;
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

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	
	// Autres méthodes :
	@Override
	public String toString() {
		return "Enchere [noRetrait=" + getNoRetrait()+ ", rue=" + getRue() + ", codePostal=" + getCodePostal() + ", ville=" + getVille()
				+ ", Article=" + getArticle() + ", utilisateur=" + getUtilisateur() + "]";
	}	
	
	
	
	
	
	
	
	
}
