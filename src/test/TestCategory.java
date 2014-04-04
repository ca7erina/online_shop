package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Category;
import entity.Product;


import util.HibernateUtil;


public class TestCategory {
	//@Test
	public void listBooksByCatg(){
		Session session=HibernateUtil.getSession();
		Category cat=(Category)session.get(Category.class,10);
		System.out.println(" Category id:  "+cat.getId());
		System.out.println(" name :"+cat.getName());
		for(Product p:cat.getProducts()){
			System.out.println(p.getProductname());
		}
	}
	
	//Set products to category
	@Test
	public void addRelation(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Category cat=(Category) session.get(Category.class, 15);
		Product pro1=(Product) session.get(Product.class, 4);
		Product pro2=(Product) session.get(Product.class, 5);
		Product pro3=(Product) session.get(Product.class, 6);
		cat.getProducts().add(pro1);
		cat.getProducts().add(pro2);
		cat.getProducts().add(pro3);
		session.update(cat);
		tx.commit();
		HibernateUtil.close();
	}
	//@Test
	public void testDelete(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Product p=(Product)session.get(Product.class, 21);
		session.delete(p);
		tx.commit();
		HibernateUtil.close();
	}
	
}
