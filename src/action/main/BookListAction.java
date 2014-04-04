package action.main;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dao.CategoryDao;
//import dao.JdbcBookDao;
//import dao.JdbcCategoryDao;
import dao.hibernate.HibernateBookDao;
import dao.hibernate.HibernateCategoryDao;

import entity.Book;
import entity.Category;

public class BookListAction {
	
	List<Book> books= new ArrayList<Book>();
	int page=1;
	int pagesize=5;
	int totalPage=1;
	int ctgy;
	Integer subctgy;
	Category category= new Category();
	List<Category> subctgys= new ArrayList<Category>();
	BookDao dao= new HibernateBookDao();
	CategoryDao cdao= new HibernateCategoryDao();
	
	public String execute() throws Exception{
		
		category=cdao.findCategoryById(ctgy);
		subctgys=cdao.findSubCategory(ctgy);
		
		if(subctgy==null){
			books=dao.getPageBreakProductByCtgy(ctgy, page, pagesize);
			totalPage=dao.getTotalPage(ctgy, pagesize);
			System.out.println("return books: "+books.size());
			return "success";
			
		}else{
			books=dao.getPageBreakProductByCtgy(subctgy, page, pagesize);
			totalPage=dao.getTotalPage(subctgy, pagesize);
			System.out.println("return books: "+books.size());
			return "success";
		}
			
		
	
	}


	



	public int getTotalPage() {
		return totalPage;
	}






	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}






	public int getPage() {
		return page;
	}






	public void setPage(int page) {
		this.page = page;
	}






	public int getPagesize() {
		return pagesize;
	}






	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}






	public Integer getSubctgy() {
		return subctgy;
	}






	public void setSubctgy(Integer subctgy) {
		this.subctgy = subctgy;
	}






	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCtgy() {
		return ctgy;
	}

	public void setCtgy(int ctgy) {
		this.ctgy = ctgy;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public List<Category> getSubctgys() {
		return subctgys;
	}

	public void setSubctgys(List<Category> subctgys) {
		this.subctgys = subctgys;
	}



	
	
}
