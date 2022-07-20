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


public class Connexion extends HttpServlet  {
	private static final long serialVersionUID = 1L ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
    }
    
    
    // Point d'entrée :
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/connexion");
		rd.forward(request, response);
	}
	
	

	// Connexion (test de connexion, renvoie vers la bonne session ou message d'erreur).
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mp = request.getParameter("mp");
		RequestDispatcher rd = null;
		try {
			if(UtilisateurManager.getInstance().Connexion(pseudo, mp) == true) {
				Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateurByPseudo(pseudo);
				HttpSession session = request.getSession();
				String id = request.getParameter("pseudo");
				System.out.println(id);
				session.setAttribute("pseudo", id);
				if(utilisateur.isAdministrateur() == true){
					rd = request.getRequestDispatcher("/administrateur");
				} else {
					rd = request.getRequestDispatcher("/utilisateur");	
				}
			}else{ 
				String non = "Authentification incorrecte";
				request.setAttribute("refuse", non);
				rd = request.getRequestDispatcher("/accueil");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request, response);
	}


	
	
	
	
	
	
}







