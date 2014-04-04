package dao.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Query;



import util.DbUtil;
import util.HibernateUtil;

import dao.BookDao;
import dao.ProductDao;
import dao.jdbc.JdbcBookDao;
import entity.Book;
import entity.Category;
import entity.Product;

public class HibernateBookDao extends JdbcBookDao{
	
	
	public List<Book> findAll() throws Exception {
		String hql="from Book";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setCacheable(true);
		List<Book> list=query.list();
		return list;
	}
	public List<Book> findProductByCtgy(int ctgy) throws Exception {	
		List<Book> list= new ArrayList<Book>();
		Category cat=(Category)HibernateUtil.getSession().get(Category.class,ctgy);
		System.out.println(" Category id:  "+cat.getId());
		System.out.println(" name :"+cat.getName());
		 for (Product p:cat.getProducts()){
			 list.add((Book) p);
		 }
		return list;
	}

	public List<Book> findRecommendProduct() throws Exception {
		String hql="from Book ";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setFirstResult(new Random().nextInt(findAll().size()-3));
		query.setMaxResults(2);
		
		List<Book> list=query.list();
		return list;
	
	}

	public List<Book> getPageBreakProductByCtgy(int ctgy, int page, int pagesize) throws Exception {
		
		List<Book> l= new ArrayList<Book>();
		List<Book> list= new ArrayList<Book>();
		Category cat=(Category)HibernateUtil.getSession().get(Category.class,ctgy);
		
		 for (Product p:cat.getProducts()){
			 l.add((Book)p);
		 }
		 System.out.println("total size:"+l.size());
		 System.out.println("page:"+page);
		 System.out.println("pagesize:"+pagesize);
		 int totalNum=l.size();
		if( page*pagesize>totalNum&&totalNum%pagesize!=0){
			int howmany=totalNum%pagesize;
			int start=totalNum;
			int a=0;
			for (int i=totalNum-1;i>=(page-1)*pagesize;i--){
				list.add(l.get(i)) ;
			 }
			
			
		}else{
			
			 for (int i=(page-1)*pagesize;i<(page-1)*pagesize+pagesize;i++){
				 System.out.println("index :"+i);
				list.add(l.get(i)) ;
				System.out.println(list.size());
			 }
			
			
		}
		 
		 System.out.println(l.size());
		 return list;
	}

	public int getTotalPage(int ctgy, int pagesize) throws Exception {
		List<Book> list=findProductByCtgy(ctgy);
		int items= list.size();
		int totalPage=items%pagesize==0?items/pagesize:items/pagesize+1;
		System.out.println("(totalpage) books:"+list.size());
		System.out.println("get totalpage:"+totalPage);
		return totalPage;
	}

	
}
