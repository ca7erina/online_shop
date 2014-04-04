package action.main;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
//import dao.JdbcCategoryDao;
import dao.hibernate.HibernateCategoryDao;

import entity.Category;

public class CategoryAction {
	
	List<Category> categories= new ArrayList<Category>();
	CategoryDao dao= new HibernateCategoryDao();
	public String execute() throws Exception{
		
		categories=dao.findAll();
		return "success";
		
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
