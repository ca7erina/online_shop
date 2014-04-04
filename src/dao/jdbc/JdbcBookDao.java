package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.BookDao;



import util.DbUtil;

import entity.Book;
import entity.Product;





public class JdbcBookDao implements BookDao{

	private final String getRecommend="select * from d_product  a join d_book b on a.id=b.id  limit ?,2";
	private final String getAll="select * from d_product  a join d_book b on a.id=b.id";
	private final String getByCtgy="select * from d_category_product d join " +
			"(select a.id productId ,product_name,description,add_time,fixed_price,dang_price,keywords,has_deleted,product_pic,author,publishing,publish_time ,word_number,which_edtion,total_page,print_time,print_number,isbn,author_summary,catalogue " +
			"from d_product  a join d_book b on a.id=b.id ) c " +
			"on c.productId=d.product_id where cat_id=? ";

	private final String getByCtgyPerPage="select * from d_category_product d join " +
	"(select a.id productId ,product_name,description,add_time,fixed_price,dang_price,keywords,has_deleted,product_pic,author,publishing,publish_time ,word_number,which_edtion,total_page,print_time,print_number,isbn,author_summary,catalogue " +
	"from d_product  a join d_book b on a.id=b.id ) c " +
	"on c.productId=d.product_id where cat_id=? limit ?,?";		 
	
	public List<Book> findAll() throws Exception {
		List<Book> newProducts = new ArrayList<Book>();
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getAll);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Book p= new Book();
			p.setId(rs.getInt("id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			p.setAuthor(rs.getString("author"));
			p.setPublishing(rs.getString("publishing"));
			p.setPublishTime(rs.getLong("publish_time"));
			p.setWordNumber(rs.getString("word_number"));
			p.setSummary(rs.getString("author_summary"));
			p.setCatalogue(rs.getString("catalogue"));
			p.setIsbn(rs.getString("isbn"));
			newProducts.add(p);
		}
		System.out.println("find All book"+newProducts);
		return newProducts;
	}

	public List<Book> findProductByCtgy(int id) throws Exception {
		List<Book> books = new ArrayList<Book>();
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getByCtgy);
		pstm.setInt(1,id);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Book p= new Book();
			p.setId(rs.getInt("product_id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			p.setAuthor(rs.getString("author"));
			p.setPublishing(rs.getString("publishing"));
			p.setPublishTime(rs.getLong("publish_time"));
			p.setWordNumber(rs.getString("word_number"));
			p.setSummary(rs.getString("author_summary"));
			p.setCatalogue(rs.getString("catalogue"));
			p.setIsbn(rs.getString("isbn"));
			
			books.add(p);
			
		}
		System.out.println("find by category id"+id+"   "+books);
		return books;
	}

	public List<Book> findRecommendProduct() throws Exception {
		Random rand =new Random();
		
		List<Book> newProducts = new ArrayList<Book>();
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getRecommend);
		pstm.setInt(1,rand.nextInt(findAll().size()-3));
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Book p= new Book();
			p.setId(rs.getInt("id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			p.setAuthor(rs.getString("author"));
			p.setPublishing(rs.getString("publishing"));
			p.setPublishTime(rs.getLong("publish_time"));
			p.setWordNumber(rs.getString("word_number"));
			p.setSummary(rs.getString("author_summary"));
			p.setCatalogue(rs.getString("catalogue"));
			p.setIsbn(rs.getString("isbn"));
			newProducts.add(p);
		}
		System.out.println("find randomProduct"+newProducts);
	
		return newProducts;
	
	}

	public List<Book> getPageBreakProductByCtgy(int ctgy ,int page,int pagesize) throws Exception {
		List<Book> books = new ArrayList<Book>();
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getByCtgyPerPage);
		int index=1;
		pstm.setInt(index++,ctgy);
		pstm.setInt(index++,(page-1)*pagesize+1);
		pstm.setInt(index++,pagesize);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Book p= new Book();
			p.setId(rs.getInt("product_id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			p.setAuthor(rs.getString("author"));
			p.setPublishing(rs.getString("publishing"));
			p.setPublishTime(rs.getLong("publish_time"));
			p.setWordNumber(rs.getString("word_number"));
			p.setSummary(rs.getString("author_summary"));
			p.setCatalogue(rs.getString("catalogue"));
			p.setIsbn(rs.getString("isbn"));
			
			books.add(p);
		}
		System.out.println("find by category id on Page:"+books);
	
		return books;
		
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
