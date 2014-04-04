package action.main;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dao.hibernate.HibernateBookDao;
import entity.Book;


public class RecommendAction {
	List<Book> recommendProducts= new ArrayList<Book>();
	BookDao dao= new HibernateBookDao();
	public String execute() throws Exception{
		
		recommendProducts=dao.findRecommendProduct();
		return "success";
		
	}

	public List<Book> getRecommendProducts() {
		return recommendProducts;
	}

	public void setRecommendProducts(List<Book> recommendProducts) {
		this.recommendProducts = recommendProducts;
	}

	
	
	
}
