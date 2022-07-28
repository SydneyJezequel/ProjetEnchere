package fr.eni.projetenchere.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
	 * @doGet : Méthode permettant la redirection vers la JSP "Nouvelle Vente".
	 * @Etapes : Cette méthode contrôle si la session est ouverte. Si la session est ouverte,
	 * elle récupère l'identifiant de l'utilisateur, la liste des catégories d'article et la date du jour,
	 * elle les stocke dans la session. Puis elle renvoie l'utilisateur sur la JSP "NouvelleVente".
	 * @ServletException : Cette méthode propage les erreurs de type ServletException.
	 * @IOException : Cette méthode propage les erreurs de type IOException.
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
				session.setAttribute("utilisateurConnecte", utilisateur);
				List<Categorie> listeCate = new ArrayList();
				listeCate = VenteManager.getInstance().selectAllCategories();
				session.setAttribute("ListeCategories", listeCate);
				long millis=System.currentTimeMillis();  
			    Date date = new java.sql.Date(millis);       
				session.setAttribute("date", date);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/NouvelleVente.jsp");
			}
		} catch (SQLException | BusinessException e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
		} finally {
			rd.forward(request, response); 
		}
	}
	
		
		
	/**
	 * @doPost : Récupération des champs de Nouvelle Vente & renvoie vers la JSP de validation.
	 * @Etapes : Cette fonction récupère les champs du formulaire, elle construit les objets à 
	 * passer en paramètre de la méthode "insertNouvelleVente(articleVendu, retrait, enchere)", 
	 * elle appelle la méthode "insertNouvelleVente(articleVendu, retrait, enchere)".
	 * @ServletException : Cette méthode propage les erreurs de type ServletException.
	 * @IOException : Cette méthode propage les erreurs de type IOException.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("id") == null) {
				rd = request.getRequestDispatcher("/Connexion");
			} else {
				Article articleVendu;
				Categorie categorieArt;
				Retrait retrait; 
				Enchere enchere;
				String nomArticle;
				String description;
				String categorie;
				FileInputStream photo;
				/*InputStream photoArticle; // A revoir dans la DAL ????*/
				int prixInitial;
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String debutEnchereStr;
				Date debutEnchere;
				String finEnchereStr;
				Date finEnchere;
				String utilisateurConnecte = (String) session.getAttribute("id");
				String rue;
				String codePostal;
				String ville;
				String idUtilisateur = (String) session.getAttribute("id");
				Utilisateur vendeur = new Utilisateur();
				vendeur = UtilisateurManager.getInstance().getUtilisateurByPseudo(idUtilisateur);
			
				nomArticle = request.getParameter("article");
				description = request.getParameter("description");
				categorie = request.getParameter("categorie");
				Part img = request.getPart("file"); // TRAITEMENT DE LA PHOTO
				File file = new File("img");/* A re-contrôler : Comment intégrer la photo ??? */
			    photo = new FileInputStream(file);
				prixInitial = Integer.parseInt(request.getParameter("prixDepart"));
				debutEnchereStr = request.getParameter("debutEnchere");
				debutEnchere = (Date) format.parse(debutEnchereStr);
				finEnchereStr = request.getParameter("finEnchere");
				finEnchere = (Date) format.parse(finEnchereStr);
				rue = request.getParameter("rue");
				codePostal = request.getParameter("codePostal");
				ville = request.getParameter("ville");
				categorieArt = new Categorie(categorie);
				articleVendu = new Article(nomArticle, description, photo, debutEnchere, finEnchere, prixInitial, vendeur, categorieArt);
				retrait = new Retrait(rue, codePostal, ville, articleVendu); 
				enchere = new Enchere(vendeur, articleVendu, debutEnchere, prixInitial);
				VenteManager.getInstance().insertNouvelleVente(articleVendu, retrait, enchere);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/VendreArticle.jsp");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("/WEB-INF/jsp/message_erreur.jsp");
		} finally {
			rd.forward(request, response);
		}
	}

}
