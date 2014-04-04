package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.ProductDao;



import util.DbUtil;

import entity.Book;
import entity.Product;





public class JdbcProductDao implements ProductDao{
	private final String getAll="select * from d_product";
	private final String getNew="select * from d_product  Order by add_time desc limit 0,16";
	private final String getHot="select * from d_product  limit ?,8 ";
	private final String getProductById="select * from d_product where id=?";
	
	public List<Product> findHotProduct() throws Exception {
		Random rand =new Random();
		List<Product> newProducts = new ArrayList<Product>();
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getHot);
		pstm.setInt(1,rand.nextInt(findAll().size()-6));
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Product p= new Product();
			p.setId(rs.getInt("id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			newProducts.add(p);
		}
		System.out.println("find randomProduct"+newProducts);
		return newProducts;
	}
	public List<Product> findAll() throws Exception {
		List<Product> newProducts = new ArrayList<Product>();
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getAll);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Product p= new Product();
			p.setId(rs.getInt("id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			newProducts.add(p);
		}
		System.out.println("find All"+newProducts);
		return newProducts;
	}
	public List<Product> findNewProduct() throws Exception {
		List<Product> newProducts = new ArrayList<Product>();
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getNew);
	
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Product p= new Product();
			p.setId(rs.getInt("id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			newProducts.add(p);
		}
		System.out.println("find newProduct"+newProducts);
		return newProducts;
	}

	public Product findProductById(int id) throws Exception{
		
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getProductById);
		pstm.setLong(1, id);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Product p= new Product();
			p.setId(rs.getInt("id"));
			p.setProductname(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddtime(rs.getLong("add_time"));
			p.setFixedprice(rs.getDouble("fixed_price"));
			p.setDangprice(rs.getDouble("dang_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdeleted(rs.getInt("has_deleted"));
			p.setProductpic(rs.getString("product_pic"));
			System.out.println("find by id -> "+p);
			return p;
		}
		return null;
	}



	
	
	
	
	
}
