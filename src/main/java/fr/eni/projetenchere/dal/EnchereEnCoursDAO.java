package fr.eni.projetenchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchere.BusinessException;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.EnchereEnCours;

public interface EnchereEnCoursDAO {
	
	public List<EnchereEnCours> selectAll() throws SQLException, BusinessException;

	public EnchereEnCours selectById(int noCategorie);

	public List<Categorie> selectCategories() throws BusinessException;

	public List<EnchereEnCours> selectByFilter(String filtre) throws BusinessException;

	public List<EnchereEnCours> selectByCategorie(int noCategorie) throws BusinessException;

	public List<EnchereEnCours> selectByFilterAndCategorie(String filtre, int noCategorie) throws BusinessException;

}
