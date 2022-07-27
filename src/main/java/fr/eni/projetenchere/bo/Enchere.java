package fr.eni.projetenchere.bo;

import java.io.Serializable;
import java.sql.Date;



public class Enchere implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	// Attributs :
	private int noEnchere;
	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	private Article Articlevendu;

	
	
	// Constructeurs :
	
	public Enchere() {}
	
	public Enchere(Utilisateur utilisateur, Article articlevendu, Date dateEnchere, int montantEnchere) {
		this();
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
		setUtilisateur(utilisateur);
		setArticleVendu(articlevendu);
	}
	public Enchere(int noEnchere, Utilisateur utilisateur, Article articlevendu, Date dateEnchere, int montantEnchere) {
		this(utilisateur, articlevendu, dateEnchere, montantEnchere);
		setNoEnchere(noEnchere);
	}
	
	
	
	// Autres méthodes :
	@Override
	public String toString() {
		return "Encheres [noEnchere=" + getNoEnchere() + ", dateEnchere=" + getDateEnchere() + ", montantEnchere="
				+ getMontantEnchere() + ", noUtilisateur=" + getUtilisateur() + ", noArticle=" + getArticleVendu() + "]";
	}
	
	
	
	// Getters & Setters :

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere2) {
		this.dateEnchere = dateEnchere2;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Article getArticleVendu() {
		return Articlevendu;
	}

	public void setArticleVendu(Article Articlevendu) {
		this.Articlevendu = Articlevendu;
	}	
	
	
	
	
	
	
	
	
	
}
