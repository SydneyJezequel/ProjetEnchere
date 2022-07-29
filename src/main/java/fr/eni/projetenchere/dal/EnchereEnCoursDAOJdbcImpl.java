package fr.eni.projetenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.EnchereEnCours;

public class EnchereEnCoursDAOJdbcImpl implements EnchereEnCoursDAO {
	
	private static final String SELECT_ALL_CATEGORIE ="SELECT no_categorie, libelle FROM Categories c ORDER BY c.libelle ASC";
	private static final String SELECT_ALL ="SELECT u.pseudo, a.nom_article, a.date_fin_encheres, a.prix_initial " + 
											"FROM Utilisateurs u " + 
											"INNER JOIN Articles a ON u.no_utilisateur = a.no_utilisateur " + 
											"ORDER BY a.date_fin_encheres DESC";
	private static final String SELECT_BY_FILTER ="SELECT u.pseudo, a.nom_article, a.date_fin_encheres, a.prix_initial " + 
			"FROM Utilisateurs u " + 
			"INNER JOIN Articles a ON u.no_utilisateur = a.no_utilisateur " + 
			"WHERE a.nom_article LIKE ? "+
			"ORDER BY a.date_fin_encheres DESC";
	private static final String SELECT_BY_CATEGORIE ="SELECT u.pseudo, a.nom_article, a.date_fin_encheres, a.prix_initial " + 
			"FROM Utilisateurs u " + 
			"INNER JOIN Articles a ON u.no_utilisateur = a.no_utilisateur " + 
			"INNER JOIN Categories c ON a.no_categorie = c.no_categorie " +
			"WHERE c.no_categorie = ? " + 
			"ORDER BY a.date_fin_encheres DESC";
	private static final String SELECT_BY_FILTER_AND_CATEGORIE ="SELECT u.pseudo, a.nom_article, a.date_fin_encheres, a.prix_initial " + 
			"FROM Utilisateurs u " + 
			"INNER JOIN Articles a ON u.no_utilisateur = a.no_utilisateur " + 
			"INNER JOIN Categories c ON a.no_categorie = c.no_categorie " +
			"WHERE c.no_categorie = ? AND a.nom_article LIKE ? " + 
			"ORDER BY a.date_fin_encheres DESC";

	
	@Override
	public List<Categorie> selectCategories() throws BusinessException {
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pstmt.executeQuery();
			Categorie categorie=null;
			while(rs.next())
			{
				categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				listeCategories.add(categorie);
				System.out.println(categorie);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_CATEGORIES_ECHEC);
			throw businessException;
		}
		return listeCategories;
	}

	@Override
	public List<EnchereEnCours> selectAll() throws SQLException, BusinessException {
		// TODO Auto-generated method stub
		
			List<EnchereEnCours> listeEncheres = new ArrayList<EnchereEnCours>();
			try(Connection cnx = ConnectionProvider.getConnection())
			{
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
				ResultSet rs = pstmt.executeQuery();
				LocalDate aujourdhui = LocalDate.now();
				EnchereEnCours enchereEnCours=null;
				while(rs.next())
				{
					
					if(rs.getDate("date_fin_encheres").toLocalDate().isAfter(aujourdhui)) {
					enchereEnCours = new EnchereEnCours(rs.getString("pseudo"), rs.getString("nom_article"), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"));
						listeEncheres.add(enchereEnCours);
						System.out.println(enchereEnCours);
					}
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_EN_COURS_ECHEC);
				throw businessException;
			}
			return listeEncheres;
		}
		

	
	@Override
	public List<EnchereEnCours> selectByFilter(String filtre) throws BusinessException {
		List<EnchereEnCours> listeEncheres = new ArrayList<EnchereEnCours>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_FILTER);
			pstmt.setString(1, filtre + "%");
			System.out.println(pstmt);
			ResultSet rs = pstmt.executeQuery();
			LocalDate aujourdhui = LocalDate.now();
			EnchereEnCours enchereEnCours=null;
			while(rs.next())
			{
				
				if(rs.getDate("date_fin_encheres").toLocalDate().isAfter(aujourdhui)) {
				enchereEnCours = new EnchereEnCours(rs.getString("pseudo"), rs.getString("nom_article"), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"));
					listeEncheres.add(enchereEnCours);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_FILTRE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
		
	}
	
	@Override
	public List<EnchereEnCours> selectByCategorie(int noCategorie) throws BusinessException {
		List<EnchereEnCours> listeEncheres = new ArrayList<EnchereEnCours>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
			pstmt.setInt(1, noCategorie);
			System.out.println(pstmt);
			ResultSet rs = pstmt.executeQuery();
			LocalDate aujourdhui = LocalDate.now();
			EnchereEnCours enchereEnCours=null;
			while(rs.next())
			{
				
				if(rs.getDate("date_fin_encheres").toLocalDate().isAfter(aujourdhui)) {
					enchereEnCours = new EnchereEnCours(rs.getString("pseudo"), rs.getString("nom_article"), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"));
					listeEncheres.add(enchereEnCours);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_CATEGORIE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
		
	}
	
	@Override
	public List<EnchereEnCours> selectByFilterAndCategorie(String filtre, int noCategorie) throws BusinessException {
		List<EnchereEnCours> listeEncheres = new ArrayList<EnchereEnCours>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_FILTER_AND_CATEGORIE);
			pstmt.setInt(1, noCategorie);
			pstmt.setString(2, filtre + "%");
			System.out.println(pstmt);
			ResultSet rs = pstmt.executeQuery();
			LocalDate aujourdhui = LocalDate.now();
			EnchereEnCours enchereEnCours=null;
			while(rs.next())
			{
				if(rs.getDate("date_fin_encheres").toLocalDate().isAfter(aujourdhui)) {
					enchereEnCours = new EnchereEnCours(rs.getString("pseudo"), rs.getString("nom_article"), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"));
					listeEncheres.add(enchereEnCours);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERES_FILTRE_ET_CATEGORIE_ECHEC);
			throw businessException;
		}
		return listeEncheres;
		
	}
	
	
}
