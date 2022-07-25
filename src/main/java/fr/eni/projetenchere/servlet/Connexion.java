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

public class Connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
		super();
	}

	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) Méthode qui est le point d'entrée de la connexion.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		rd.forward(request, response);
	}

	
	
	// Connexion (test de connexion, renvoie vers la bonne session ou message
	// d'erreur).
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) Méthode qui gère la connexion de l'utilisateur.
	 * @Etapes : Récupère les pseudo et mot de passe renseignés, Vérifie les pseudos
	 *         et mots de passe, Si pseudos et mots de passe ok : récupère
	 *         l'utilisateur en BDD et ouvre une session, récupère les identifiants
	 *         et pseudos de l'utilisateur, renvoie vers une JSP différente si
	 *         Client ou si Admin.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mp = request.getParameter("mp");
		RequestDispatcher rd = null;
		try {
			if (UtilisateurManager.getInstance().ControleDeConnexion(pseudo, mp) == true) {
				Utilisateur utilisateurConnecte = UtilisateurManager.getInstance().getUtilisateurByPseudo(pseudo);
				String id = (String) utilisateurConnecte.getPseudo();
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("pseudo", pseudo);
				if (utilisateurConnecte.isAdministrateur() == true) {
					rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil_administrateur.jsp");
				} else {
					rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil_utilisateur.jsp");
				}
			} else {
				String non = "Authentification incorrecte";
				request.setAttribute("refuse", non);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
		}
		rd.forward(request, response);
	}

	

	
	
}




