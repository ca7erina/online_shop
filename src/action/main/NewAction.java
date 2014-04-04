package action.main;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.hibernate.HibernateProductDao;
import entity.Product;

public class NewAction {
	
	List<Product> newProducts= new ArrayList<Product>();
	ProductDao dao= new HibernateProductDao();
	public String execute() throws Exception{
		
		newProducts=dao.findNewProduct();
		return "success";
		
	}

	public List<Product> getNewProducts() {
		return newProducts;
	}

	public void setNewProducts(List<Product> newProducts) {
		this.newProducts = newProducts;
	}

	
	
	
}
