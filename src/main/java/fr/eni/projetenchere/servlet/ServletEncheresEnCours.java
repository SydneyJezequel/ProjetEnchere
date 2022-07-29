package fr.eni.projetenchere.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bll.EnchereEnCoursManager;
import fr.eni.projetenchere.bo.Categorie;

/**
 * Servlet implementation class ListeEnchere
 */
//@WebServlet("/ServletEncheresEnCours")
public class ServletEncheresEnCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Méthode permettant d'afficher toutes les enchères en cours dans la jsp accueil
	 * @param request et response
	 * @Etapes Appelle la méthode afficherCategories pour transmettre à la jsp accueil la liste des catégories
	 * Cette méthode fait appel à une fonctions d'EnchereEnCoursManager :selectionnerTout
	 * qui permet d'interroger la BDD au travers de la DAL pour récupérer toutes les enchères en cours.
	 * @throws ServletException, IOException : Les exceptions sont propagées depuis la classe EnchereEnCoursDAOJdbcImpl.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		afficherCategories(request);
		
		try {
			request.setAttribute("listeEncheres", EnchereEnCoursManager.getInstance().selectionnerTout());
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);
	}
	
	/**
	 * Méthode permettant de récupérer les informations du formulaire pour filtrer par catégorie ou avec une partie du nom.
	 * @param request et response
	 * @Etapes Appelle la méthode afficherCategories pour transmettre à la jsp accueil la liste des catégories
	 * Ensuite, en fonction des choix de l'utilisateur, on fait appel à 4 fonctions d'EnchereEnCoursManager :
	 * selectionnerCategorie, selectionnerFiltre, selectionnerFiltreEtCategorie
	 * Ces fonctions permettent d'interroger la BDD au travers de la DAL pour filtrer les informations sur les enchères en cours.
	 * @throws ServletException, IOException : Les exceptions sont propagées depuis la classe EnchereEnCoursDAOJdbcImpl.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// Envoie la liste des catégories à la jsp accueil
		afficherCategories(request);
		
		// Recupère les catégories
		List<Categorie> categories = new ArrayList<>();
		categories = getCategories();
		// récupère dans une liste les numéro de catégories
		List<Integer> idCategories = new ArrayList<>();
		for(Categorie c : categories){
			idCategories.add(c.getNoCategorie());
		}

		//lecture filtre et numéro de catégorie
		String filtre ="";
		if(request.getParameter("srecherche")!=null) {
			filtre = request.getParameter("srecherche");
		}
		int noCategorie =0;
		if(request.getParameter("scategorie")!=null) {
			noCategorie = Integer.parseInt(request.getParameter("scategorie"));
		} 

//    	int noCategorie = Integer.parseInt(request.getParameter("scategorie"));
		
    	// affichages des articles en vente si le filtre n'est pas renseigné pour la recherche même avec le nom incomplet
		if(filtre =="") {
			// affichage des articles si aucune catégorie n'est choisie
			if(!idCategories.contains(noCategorie)) {
				doGet(request, response);
				
			// affichage des articles en filtrant par une catégorie
			} else {
				
				try {
					request.setAttribute("listeEncheres", EnchereEnCoursManager.getInstance().selectionnerCategorie(noCategorie));
				} catch (BusinessException | SQLException e) {
					e.printStackTrace();
					request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
					RequestDispatcher rd = request.getRequestDispatcher("/accueil");
					rd.forward(request, response);
				}
			}
	    	
		// affichages des articles en vente si le filtre est renseigné pour la recherche même avec le nom incomplet
		} else {
			// affichage des articles si aucune catégorie n'est choisie
			if(!idCategories.contains(noCategorie)) {
				try {
					request.setAttribute("listeEncheres", EnchereEnCoursManager.getInstance().selectionnerFiltre(filtre));
				} catch (BusinessException | SQLException e) {
					e.printStackTrace();
					request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
					RequestDispatcher rd = request.getRequestDispatcher("/accueil");
					rd.forward(request, response);
				}
			// affichage des articles en filtrant par une catégorie
			} else {
				System.out.println(Arrays.asList(idCategories));
				try {
					request.setAttribute("listeEncheres", EnchereEnCoursManager.getInstance().selectionnerFiltreEtCategorie(filtre, noCategorie));
				} catch (SQLException | BusinessException e) {
					e.printStackTrace();
					request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
					RequestDispatcher rd = request.getRequestDispatcher("/accueil");
					rd.forward(request, response);
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);
		doGet(request, response);
	}
	
	/**
	 * Méthode permettant de récupérer la liste des catégories
	 * @return une liste de cétégories
	 * @Etapes Appelle la méthode de la DAL selectionnerCategories
	 * @throws SQLException : Les exceptions sont propagées depuis la classe EnchereEnCoursDAOJdbcImpl.
	 */
	protected List<Categorie> getCategories() throws ServletException, IOException {
		
		List<Categorie> categories = new ArrayList<>();
		
		try {
			categories = EnchereEnCoursManager.getInstance().selectionnerCategories();
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	protected void afficherCategories(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			request.setAttribute("listeCategories", EnchereEnCoursManager.getInstance().selectionnerCategories());
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
		}
	}

}
