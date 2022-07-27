package fr.eni.projetenchere.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurManager;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int CREDIT = 1000;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		List<Integer> listeCodesErreur=new ArrayList<>();
//		BusinessException businessException = new BusinessException();
		
		
		
    	int credit = CREDIT;
    	boolean admin = false;
		//lecture pseudo
    	String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
//		if(telephone==null) {
//			telephone = "";
//		}
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		String confirmation = request.getParameter("confirmation");
		
		System.out.println(pseudo +  " " + nom +" "+prenom+" "+telephone+ " "+email+" "+rue+" "+code_postal+" "+ville+" "+ mdp + " / " + confirmation);
		//Réalisation du traitement

		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mdp, credit, admin);


		//J'ajoute l'utilisateur
		try {
			UtilisateurManager.getInstance().ajoutUtilisateur(utilisateur, confirmation);
			//Si tout se passe bien, je vais vers la page d'accueil:
			RequestDispatcher rd = request.getRequestDispatcher("/accueil");
			rd.forward(request, response);
		} catch (BusinessException | DALException | SQLException | BLLException e) {
			//Sinon je retourne à la page d'inscription pour indiquer les problèmes:
			e.printStackTrace();
			request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
			rd.forward(request, response);
		}
			
		doGet(request, response);
	}
}
