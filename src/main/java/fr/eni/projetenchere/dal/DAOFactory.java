package fr.eni.projetenchere.dal;

public abstract class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	
	public static VenteDAO getVenteDAO() {
		return new VenteDAOJdbcImpl();
	}
	
	
	

}
