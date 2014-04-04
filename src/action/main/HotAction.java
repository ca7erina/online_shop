package action.main;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.hibernate.HibernateProductDao;
import entity.Product;

public class HotAction {
	
	List<Product> hotProducts= new ArrayList<Product>();
	ProductDao dao= new HibernateProductDao();
	public String execute() throws Exception{
		
		hotProducts=dao.findHotProduct();
		return "success";
		
	}

	public List<Product> getHotProducts() {
		return hotProducts;
	}

	public void setHotProducts(List<Product> hotProducts) {
		this.hotProducts = hotProducts;
	}

	
	
}
