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
				rd = request.getRequestDispatcher("/utilisateur");
			} else {
				String utilisateurConnecte = (String) session.getAttribute("id");
				Utilisateur utilisateur = new Utilisateur();
				utilisateur = UtilisateurManager.getInstance().getUtilisateurByPseudo(utilisateurConnecte);
				session.setAttribute("nom", utilisateur.getNom());
				session.setAttribute("prenom", utilisateur.getPrenom());
				session.setAttribute("email", utilisateur.getEmail());
				session.setAttribute("telephone", utilisateur.getTelephone());
				session.setAttribute("rue", utilisateur.getRue());
				session.setAttribute("codePostal", utilisateur.getCodePostal());
				session.setAttribute("ville", utilisateur.getVille());
				rd = request.getRequestDispatcher("/affichProfil");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Renvoyer vers une page jsp qui va afficher le message d'erreur.
		}
		rd.forward(request, response);
	}

	
	


		
		
		
}
