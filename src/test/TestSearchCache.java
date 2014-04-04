package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import util.HibernateSessionFactory;

import entity.Product;



public class TestSearchCache {
  @Test
  public void test1(){
    findAll(10);
    System.out.println("-----------------");
    findAll(20);

  }
  
  public List<Product> findAll(double price){
    String hql = "from Product where dangprice>?";
    Session session =HibernateSessionFactory.getSession();
    Query query = session.createQuery(hql);
    query.setDouble(0, price);
    //指定利用查询缓存机制
    query.setCacheable(true);
    //执行查询
    List<Product> list = query.list();
    HibernateSessionFactory.closeSession();
    for(Product pro:list){
      System.out.println(pro.getId()+" "
          +pro.getProductpic());   
    }
    return list;
  }
  
  
  
  
  
}
