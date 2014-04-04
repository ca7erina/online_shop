package dao;



import java.util.List;


import entity.Book;
import entity.Product;


public interface ProductDao {

	public List<Product> findHotProduct() throws Exception;

	public List<Product> findNewProduct() throws Exception;
	public List<Product> findAll() throws Exception ;
	public Product findProductById(int id) throws Exception;
	
}
