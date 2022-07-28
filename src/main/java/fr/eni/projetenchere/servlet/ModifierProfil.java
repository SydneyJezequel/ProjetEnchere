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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("id") == null) {
				rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
			} else {
				String utilisateurConnecte = (String) session.getAttribute("id"); // On charge l'utilisateur de la BDD.
				Utilisateur utilisateur = new Utilisateur();
				utilisateur = UtilisateurManager.getInstance().getUtilisateurByPseudo(utilisateurConnecte);
				int credit = utilisateur.getCredit();
				session.setAttribute("credit", credit);
				session.setAttribute("utilisateurConnecte", utilisateur);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/modifier_profil.jsp");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		Utilisateur majUtilisateur = new Utilisateur(); // Modif.
		String modifie = null;
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String codePostal = null;
		String ville = null;
		int credit;
		String mpactuel = null;
		String nouveaumdp = null;
		String confirmation = null;
		try {
			if (session.getAttribute("id")==null){
				modifie = "nous rencontrons un problème de gestion de votre session.";
				rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
			} else {
				Utilisateur utilisateurModifie = new Utilisateur();
				utilisateurModifie = (Utilisateur) session.getAttribute("utilisateurConnecte"); 
				int id = utilisateurModifie.getNoUtilisateur(); 
				pseudo = request.getParameter("pseudo");
				nom = request.getParameter("nom");
				prenom = request.getParameter("prenom");
				email = request.getParameter("email");
				telephone = request.getParameter("telephone");
				rue = request.getParameter("rue");
				codePostal = request.getParameter("code_postal");
				ville = request.getParameter("ville");
				credit = utilisateurModifie.getCredit();
				mpactuel = request.getParameter("mdpactuel");
				nouveaumdp = request.getParameter("nouveaumdp");
				confirmation = request.getParameter("confirmation");
				if ( (nouveaumdp.isEmpty() && confirmation.isEmpty() && utilisateurModifie.getMotDePasse().equals(mpactuel) )
					|| (nouveaumdp.equals(confirmation) && !nouveaumdp.isEmpty() && mpactuel.isEmpty())
					|| ( !(nouveaumdp.equals(confirmation)) && utilisateurModifie.getMotDePasse().equals(mpactuel))	
					) {
					modifie = "Les mots de passes renseignés ne concordent pas ou le mot de passe actuel renseigné est incorrect.";
				} else { 
					if (nouveaumdp.isEmpty() && confirmation.isEmpty() && mpactuel.isEmpty()){
						nouveaumdp = utilisateurModifie.getMotDePasse();
					} else if (nouveaumdp.equals(confirmation) && utilisateurModifie.getMotDePasse().equals(mpactuel) ) {
						nouveaumdp = confirmation;
					}
					utilisateurModifie = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, nouveaumdp, credit);
					majUtilisateur = UtilisateurManager.getInstance().updateUtilisateur(utilisateurModifie); // Modif.
					session.setAttribute("utilisateurConnecte", majUtilisateur);
					modifie = "Votre Profil a été modifié.";
				}
				request.setAttribute("modifie", modifie);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/afficher_profil.jsp"); 
				}
		}catch(

	BusinessException e)
	{
		e.printStackTrace();
		request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
	}finally
	{
		rd.forward(request, response);
	}
}

}
