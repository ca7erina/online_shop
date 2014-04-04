package dao.jdbc;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;



import util.DbUtil;
import entity.Category;


public class JdbcCategoryDao implements CategoryDao{
	private final String findAll="select * from d_category";
	private final String findSubCategory="select * from d_category where parent_id =?";
	private final String findCategoryById="select * from d_category where id=?";
	private final String getCountByCtgy="select count(*) from d_category_product d join " +
	"(select a.id productId ,product_name,description,add_time,fixed_price,dang_price,keywords,has_deleted,product_pic,author,publishing,publish_time ,word_number,which_edtion,total_page,print_time,print_number,isbn,author_summary,catalogue " +
	"from d_product  a join d_book b on a.id=b.id ) c " +
	"on c.productId=d.product_id where cat_id=? ";
	public List<Category> findAll() throws Exception {
		List<Category> categories= new ArrayList<Category>();
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(findAll);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Category c= new Category();
			c.setId(rs.getInt("id"));
			c.setTurn(rs.getInt("turn"));
			c.setEnname(rs.getString("en_name"));
			c.setName(rs.getString("name"));
			c.setDescription(rs.getString("description"));
			c.setParentid(rs.getInt("parent_id"));
			c.setSubCategories(findSubCategory(c.getId()));
			c.setPnum(countBookByCtgy(c.getId()));
			categories.add(c);
		}
		//System.out.println("findAll categories:"+categories);
		
		return categories;
	}
	public int countBookByCtgy(int id)throws Exception {
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(getCountByCtgy);
		pstm.setInt(1,id);
		ResultSet rs=pstm.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	public List<Category> findSubCategory(int id) throws SQLException, Exception{
		List<Category> categories= new ArrayList<Category>();
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(findSubCategory);
		pstm.setInt(1, id);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Category c= new Category();
			c.setId(rs.getInt("id"));
			c.setTurn(rs.getInt("turn"));
			c.setEnname(rs.getString("en_name"));
			c.setName(rs.getString("name"));
			c.setDescription(rs.getString("description"));
			c.setParentid(rs.getInt("parent_id"));
			c.setPnum(countBookByCtgy(c.getId()));
			categories.add(c);
		}
		//System.out.println("findAll Subcategories:"+categories);
		return categories;
		
	}

	public Category findCategoryById(int id) throws Exception {
	
		PreparedStatement pstm= DbUtil.getConnection().prepareStatement(findCategoryById);
		pstm.setInt(1, id);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Category c= new Category();
			c.setId(rs.getInt("id"));
			c.setTurn(rs.getInt("turn"));
			c.setEnname(rs.getString("en_name"));
			c.setName(rs.getString("name"));
			c.setDescription(rs.getString("description"));
			c.setParentid(rs.getInt("parent_id"));
			c.setPnum(countBookByCtgy(c.getId()));
			System.out.println("find Category By Id:"+c);
			return c;
		}
		
		return null;
	}
	
	
	
	
}
