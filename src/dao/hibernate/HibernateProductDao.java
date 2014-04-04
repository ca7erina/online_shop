package dao.hibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;

import util.HibernateUtil;

import dao.ProductDao;
import entity.Product;

public class HibernateProductDao implements ProductDao{

	public int howManyInDB() throws Exception{
		
		return findAll().size();
		
	}
	public List<Product> findAll() throws Exception {
		String hql="from Product";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setCacheable(true);
		List<Product> list=query.list();
		return list;
	}

	public List<Product> findHotProduct() throws Exception {
		String hql="from Product ";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setFirstResult(new Random().nextInt(howManyInDB()-8));
		query.setMaxResults(8);
		List<Product> list=query.list();
		return list;
	}

	public List<Product> findNewProduct() throws Exception {
		String hql="from Product Order by addtime desc  ";
		Query query=HibernateUtil.getSession().createQuery(hql);
		
		query.setFirstResult(0);
		query.setMaxResults(16);
		List<Product> list=query.list();
		return list;
	}

	public Product findProductById(int id) throws Exception {
		String hql="from Product where id=?";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0, id);
		Product p=new Product();
		p=(Product)query.uniqueResult();
		return p;
	}

}
