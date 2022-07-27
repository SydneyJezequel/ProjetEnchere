package fr.eni.projetenchere.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bll.UtilisateurManager;
import fr.eni.projetenchere.bll.VenteManager;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class SelectbyId
 */

public class NouvelleVente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvelleVente() {
		super();
	}

	
	
	/**
	 * @doGet : Méthode permettant la redirection vers la JSP "Nouvelle Vente",
	 * 			XXXXXXXXXXXXXXXXXXXXXXXXXXX
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("id") == null) {
				rd = request.getRequestDispatcher("/Connexion");
			} else {
				String utilisateurConnecte = (String) session.getAttribute("id");
				Utilisateur utilisateur = new Utilisateur();
				utilisateur = UtilisateurManager.getInstance().getUtilisateurByPseudo(utilisateurConnecte);
				List<Categorie> listeCate = new ArrayList();
				listeCate = VenteManager.getInstance().selectAllCategories();
				long millis=System.currentTimeMillis();  
			    Date date = new java.sql.Date(millis);       
				session.setAttribute("ListeCategories", listeCate);
				session.setAttribute("utilisateurConnecte", utilisateur);
				session.setAttribute("date", date);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/VendreArticle.jsp");
			}
		} catch (SQLException | BusinessException e) {
			e.printStackTrace(); // Renvoyer vers une page jsp qui va afficher le message d'erreur.
		}
		rd.forward(request, response);
	}

	
	
	/**
	 * @doPost : Récupération des champs de Nouvelle Vente & renvoie vers la JSP de validation.
	 * @Etapes : Cette fonction récupère les champs du formulaire, XXXXXXXXXXXXXXXX
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		Article articleVendu;
		Categorie categorieArt;
		Retrait retrait; 
		Enchere enchere;
		String nomArticle;
		String description;
		String categorie; // A reprendre ?????
        InputStream photoArticle; // A revoir dans la DAL ????
		int prixInitial;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date debutEnchere;
		Date finEnchere;
		String utilisateurConnecte = (String) session.getAttribute("id");
		Utilisateur utilisateur = new Utilisateur();
		String rue;
		String codePostal;
		String ville;
		String idUtilisateur = (String) session.getAttribute("id");
		Utilisateur vendeur = new Utilisateur();
		vendeur = UtilisateurManager.getInstance().getUtilisateurByPseudo(idUtilisateur);
		try {			
				nomArticle = request.getParameter("article");
				description = request.getParameter("description");
				categorie = request.getParameter("categorie"); // A contrôler ??????
				Part filePart = request.getPart("file"); // A contrôler ??????
				photoArticle = filePart.getInputStream(); // A contrôler ??????
				prixInitial = Integer.parseInt(request.getParameter("prixDepart"));
				debutEnchere = Date.parse(request.getParameter("debutEnchere", formatter));
				finEnchere = Date.parse(request.getParameter("finEnchere"), formatter);
				rue = request.getParameter("rue");
				codePostal = request.getParameter("codePostal");
				ville = request.getParameter("ville");
				categorieArt = new Categorie(categorie);
				articleVendu = new Article(nomArticle, description, photoArticle, debutEnchere, finEnchere, prixInitial, utilisateur, categorieArt);
				retrait = new Retrait(rue, codePostal, ville, articleVendu); 
				enchere = new Enchere(vendeur, articleVendu, debutEnchere, prixInitial);
				// Appelle de la méthode dans utilisateurManger
				UtilisateurManager.getInstance().insertArticle(articleVendu, retrait, enchere); // A reprendre
				rd = request.getRequestDispatcher("/WEB-INF/jsp/VendreArticle.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
		rd.forward(request, response);
		}


		
		
		
}
