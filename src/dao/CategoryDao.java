package dao;


import java.sql.SQLException;
import java.util.List;

import entity.Category;


public interface CategoryDao {
	public List<Category> findAll() throws Exception;
	public List<Category> findSubCategory(int id) throws Exception;
	public Category findCategoryById(int id) throws Exception;

}
