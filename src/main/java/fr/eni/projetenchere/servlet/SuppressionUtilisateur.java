package fr.eni.projetenchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.UtilisateurDAO;

/**
 * Servlet implementation class SuppressionUtilisateur
 */
@WebServlet("/SuppressionUtilisateur")
public class SuppressionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurConnecte = null;
		utilisateurConnecte = (Utilisateur)request.getSession().getAttribute("utilisateurConnecte");
		if (utilisateurConnecte!=null) {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/modifier_profil.jsp" ).forward( request, response );
		} else {
			this.getServletContext().getRequestDispatcher( "/accueil" ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurConnecte = (Utilisateur)request.getSession().getAttribute("utilisateurConnecte");
		String pseudo;
		
		pseudo = utilisateurConnecte.getPseudo();
		try {
			UtilisateurDAO.supprimer(pseudo);
		} catch (DALException e) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp").forward(request, response);
		}
		request.getSession().invalidate();
		getServletContext().getRequestDispatcher("/Connexion").forward(request, response);
	}

}
