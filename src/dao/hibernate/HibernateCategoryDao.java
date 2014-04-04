package dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import util.HibernateUtil;
import dao.CategoryDao;
import entity.Category;

public class HibernateCategoryDao implements CategoryDao{

	public List<Category> findAll() throws Exception {
		String hql="from Category";
		Query query= HibernateUtil.getSession().createQuery(hql);
		query.setCacheable(true);
		List<Category> list=query.list();
		for(Category c:list){
			c.setSubCategories(findSubCategory(c.getId()));
			
		}
		
		return list;
	}

	public Category findCategoryById(int id) throws Exception {
		String hql="from Category where id=?";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0, id);
		Category c= new Category();
		c=(Category) query.uniqueResult();
		return c;
	}

	public List<Category> findSubCategory(int id) throws Exception {
		String hql="from Category where parentid=?";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0, id);
		List<Category> list=query.list();
		return list;
	}
	

}
