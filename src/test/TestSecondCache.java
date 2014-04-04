package test;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateSessionFactory;
import entity.Product;





public class TestSecondCache {
  //测试二级缓存
  @Test
  public void test1(){
    //获取一个新的Session对象,查询编号是1的产品
    Session session1 =HibernateSessionFactory.getSession();
    Product pro =(Product)session1.get(Product.class, 1);
    System.out.println(pro.getId()+" "+pro.getProductname());
    HibernateSessionFactory.closeSession();
    //获取一个新的Session对象,查询编号是1的产品
    Session session2 = HibernateSessionFactory.getSession();
    Product pro1 = (Product)session2.get(Product.class, 1);
    System.out.println(pro1.getId()+" "+pro1.getProductpic());
    HibernateSessionFactory.closeSession();
  }
}
