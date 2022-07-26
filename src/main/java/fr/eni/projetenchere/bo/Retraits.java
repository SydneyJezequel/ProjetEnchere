package fr.eni.projetenchere.bo;

public class Retraits {
	
	
	private static final long serialVersionUID = 1L;
	
	
	// Attributs :
	private int noRetrait;
	private String rue;
	private String codePostal;
	private String ville;
	private Articles article;
	
	
	// Constructeurs :
	public Retraits() {}
	
	public Retraits(String rue, String codePostal, String ville, Articles article) {
		this();
	}
	
	public Retraits(int noRetrait, String rue, String codePostal, String ville, Articles article) {
		this(rue, codePostal, ville, article);
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

	public Articles getArticle() {
		return article;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

	
	
	// Autres méthode :
	public String toString() {
		return "Retrait [ Numéro de Retrait=" + getNoRetrait() +", Rue =" + getRue() +", Code Postal= "+ getCodePostal() +", Ville=" + getVille() +", Numéro Article=" + getArticle() + "]";
	}

	
	

}
