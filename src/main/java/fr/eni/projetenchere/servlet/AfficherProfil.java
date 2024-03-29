package fr.eni.projetenchere.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bll.UtilisateurManager;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class SelectbyId
 */

public class AfficherProfil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherProfil() {
		super();
	}

	/**
	 * @doGet : Méthode permettant la redirection vers la JSP "AfficherProfil".
	 * @Etapes : Vérifie si une session est ouverte, récupère l'utilisateur stocké en BDD,
	 * stocke les attribut de l'utilisateur dans la session, redirige vers la JSP.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("id") == null) {
				rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
			} else {
				String utilisateurConnecte = (String) session.getAttribute("id");
				Utilisateur utilisateur = new Utilisateur();
				utilisateur = UtilisateurManager.getInstance().getUtilisateurByPseudo(utilisateurConnecte);
				session.setAttribute("utilisateurConnecte", utilisateur);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/afficher_profil.jsp");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
		}
		rd.forward(request, response);
	}

	
	


		
		
		
}
