package fr.eni.projetenchere.bo;

public class Retrait {
	
	
	private static final long serialVersionUID = 1L;
	
	
	// Attributs :
	int noRetrait;
	String rue;
	String codePostal;
	String ville;
	Article article;
	
	
	// Constructeurs :
	public Retrait() {}
	
	public Retrait(String rue, String codePostal, String ville, Article article) {
		this();
	}
	
	public Retrait(int noRetrait, String rue, String codePostal, String ville, Article article) {
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

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
	
	// Autres méthode :
	public String toString() {
		return "Retrait [ Numéro de Retrait=" + getNoRetrait() +", Rue =" + getRue() +", Code Postal= "+ getCodePostal() +", Ville=" + getVille() +", Numéro Article=" + getArticle() + "]";
	}

	
	

}
