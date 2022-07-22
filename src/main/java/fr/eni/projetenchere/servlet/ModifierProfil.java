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

public class ModifierProfil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierProfil() {
		super();
	}

	/**
	 * @doGet : Méthode permettant la redirection vers la JSP "ModifierProfil", le
	 *        contrôle de l'existence d'une session Utilisateur, la récupération des
	 *        données de l'utilisateur. Etapes : Vérification de l'ouverture d'une
	 *        session, Récupération du pseudo de l'utilisateur connecté, appelle de
	 *        la DAL pour récupérer l'utilisateur via le pseudo, renvoie du crédit
	 *        vers la JSP, Redirection vers la JSP.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("utilisateurConnecte") == null) {
				rd = request.getRequestDispatcher("/connexion");
			} else {
				String utilisateurConnecte = (String) session.getAttribute("id");
				Utilisateur utilisateur = new Utilisateur();
				utilisateur = UtilisateurManager.getInstance().getUtilisateurByPseudo(utilisateurConnecte);
				int credit = utilisateur.getCredit();
				session.setAttribute("credit", credit);
				session.setAttribute("utilisateur", utilisateur);
				rd = request.getRequestDispatcher("/modifProfil");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Renvoyer vers une page jsp qui va afficher le message d'erreur.
		}
		rd.forward(request, response);
	}

	
	/**
	 * @doPost : Récupération des champs de modification du Profil & renvoie du
	 *         message de validation.
	 * @Etapes : Cette fonction récupère les champs du formulaire, Définit une
	 *         réponse à renvoyer selon les champs renseignés, Teste le nouveau mot
	 *         de passe, Appelle la méthode de la BLL
	 *         updateUtilisateur(utilisateurModifie) en lui passant une instance de
	 *         type Utilisateur avec les valeurs récupérées, Renvoie la réponse
	 *         définie.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			Utilisateur utilisateurModifie = new Utilisateur();
			utilisateurModifie = (Utilisateur) session.getAttribute("utilisateur");
			int id = utilisateurModifie.getNoUtilisateur();
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String code_postal = request.getParameter("code_postal");
			String ville = request.getParameter("ville");
			String mpactuel = request.getParameter("mdpactuel");
			String nouveaumdp = request.getParameter("nouveaumdp");
			String confirmation = request.getParameter("confirmation");
			String modifie;
			if (pseudo == null & nom == null & prenom == null & email == null & telephone == null & rue == null
					& code_postal == null & ville == null & mpactuel == null & nouveaumdp == null
					& confirmation == null) {
				modifie = "Aucune information n'a été renseignée";
			} else if (nouveaumdp != null) {
				if (UtilisateurManager.getInstance().VerifMdpActuel(pseudo, mpactuel) == false) {
					modifie = "Le mot de passe renseigné est inexact.";
				} else if (nouveaumdp != confirmation) {
					modifie = "Les 2 versions du nouveau mot de passe ne concordent pas.";
				} else {
					modifie = "Votre Profil a été modifié";
				}
			} else {
				utilisateurModifie = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, code_postal, ville,
						nouveaumdp);
				UtilisateurManager.getInstance().updateUtilisateur(utilisateurModifie);
				modifie = "Votre Profil a été modifié";
				request.setAttribute("modifie", modifie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
