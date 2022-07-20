package fr.eni.projetenchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.UtilisateurManager;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class SelectbyId
 */




public class ModifierProfil extends HttpServlet  {
	private static final long serialVersionUID = 1L ;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfil() {
        super();
    }
    
    
    
    // Point d'entrée :
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/modifProfil");
		rd.forward(request, response);
	}
	
	

	// Connexion (test de connexion, renvoie vers la bonne session ou message d'erreur).
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mp = request.getParameter("mp");
		String 
		RequestDispatcher rd = null;
		try {
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request, response);
	}
	 */

	
	
	
	
	
	
}







