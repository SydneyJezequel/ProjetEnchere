package fr.eni.projetenchere.dal;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Olivier
 *
 *         Cette classe permet de recenser l'ensemble des erreurs (par leur
 *         code) pouvant survenir lors d'un traitement quel que soit la couche à
 *         l'origine.
 */
public class DALException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
	
	
	// Attributs :
	private List<Integer> listeCodesErreur;
	
	// Constructeur :
	public DALException() {
		super();
	}

	public DALException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public DALException(String message) {
		super(message);
		
	}

	
	
}