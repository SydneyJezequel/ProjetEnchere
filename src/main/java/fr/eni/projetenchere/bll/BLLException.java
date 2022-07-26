package fr.eni.projetenchere.bll;

/**
 * 
 * @author Olivier
 *
 *         Cette classe permet de recenser l'ensemble des erreurs (par leur
 *         code) pouvant survenir lors d'un traitement quel que soit la couche à
 *         l'origine.
 */
public class BLLException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	// Constructeur :
	public BLLException() {
		super();
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(String message, Throwable exception) {
		super(message, exception);
	
	}
	
	//Méthodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		return sb.toString() ;
	}
	
}