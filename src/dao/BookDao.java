package dao;

import java.util.List;


import entity.Book;
import entity.Product;



public interface BookDao {
	public List<Book> findRecommendProduct() throws Exception ;
	public List<Book> findProductByCtgy(int id) throws Exception;
	public List<Book> getPageBreakProductByCtgy(int ctgy ,int page,int pagesize) throws Exception ;
	public int getTotalPage(int ctgy, int pagesize) throws Exception;
}
