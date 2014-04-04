package test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.junit.Test;

import dao.HibernateItemDao;
import dao.ItemDao;
import dao.hibernate.HibernateOrderDao;

import util.HibernateUtil;
import util.Serialization;
import entity.CartItem;
import entity.Item;
import entity.DeliverInfo;
import entity.Order;

import entity.Product;

public class TestHibernateDao {
	//@Test
	public void saveDeliverInfo() {
		DeliverInfo info =new DeliverInfo();
		info.setFulladdress("fulladdress");
		info.setMobile("12312312");
		info.setPhone("sdfsdfsdf");
		info.setPostalcode("sfwef");
		info.setReceivename("hibernateTestor");
		info.setUserid(4);
		HibernateUtil.getSession().save(info);
		
	}
	//@Test
	public void saveProduct() {
		Transaction t=HibernateUtil.getSession().beginTransaction();
		Product product =new Product();
		product.setAddtime(System.currentTimeMillis());
		product.setDangprice(123.4);
		product.setDescription("nice book");
		product.setFixedprice(321.99);
		product.setHasdeleted(1);
		product.setKeywords("sdfsdf");
		product.setProductname("Thinking in Java");
		product.setProductpic("10.jpg");
		HibernateUtil.getSession().save(product);
		t.commit();
	}
	//@Test
	public void listProduct() {
		HibernateUtil.getSession().beginTransaction();
		Query query=HibernateUtil.getSession().createQuery("from Product");

		 List<Product> list = query.list();
		    for(Product p : list){
		      System.out.println(p.getId()+" "+
		     p.getProductname()+" "
		          +p.getDangprice()+" "+p.getFixedprice());
		    }
		    
		
	}
	//@Test
	public void listOrder() {
		HibernateUtil.getSession().beginTransaction();
		Query query=HibernateUtil.getSession().createQuery("from Order where id=1");

		 List<Order> list = query.list();
		    for(Order o : list){
		      System.out.println(o.getId()+" "+" "+" "+o.getTotalPrice());
		      Set<Item> items=o.getItems();
		      
		      System.out.println("--------------------------------------------------------------");
		    }

	}
//	@Test
	public List<Item> listItems() throws Exception{
		HibernateItemDao dao = new HibernateItemDao();
	    List<Item> list = dao.FindItems();
	    for(Item item : list){
	   //   System.out.println(item.getId()+" "+item.getProduct().getProductname()+" "+item.getProduct().getDangprice()+"  "+item.getQty());
	    }
	    return list;
	}
	
	
	//@Test
	public void listItemOrderInfoByOrderId() throws Exception{
		HibernateItemDao dao = new HibernateItemDao();
	    Item item= dao.FindById(2);
	    System.out.println(item.getId()+" "+item.getProductName()+" "+" "+item.getOrder().getId()+"   order total price:"+item.getOrder().getTotalPrice());
	}
	//@Test
	public void GetOrderById() throws Exception{
		HibernateOrderDao dao = new HibernateOrderDao();
	//    Order o= dao.FindById(1);
	//    System.out.println(o.getId()+" "+o.getOrdertime()+" "+o.getTotalPrice()+" ");
	}
	@Test
	public void SaveOrder() throws Exception{
		Transaction t=HibernateUtil.getSession().beginTransaction();
		Order o= new Order();
	//	o.setReceivename("MarryJane");
	//	o.setFulladdress("ZhongGuanCun-XueYuanNanLu,BJ,CN");
		o.setOrderdesc("ordertest1");
		o.setOrdertime(System.currentTimeMillis());
		o.setTotalPrice(1223.2);
	//	o.setUserid(1);
		
		Item i1=new Item();
		i1.setProductNum(2);
		i1.setProductName("test order casacade1");
		i1.setProductId(2);
		i1.setProductNum(5);
		i1.setOrder(o);
		
		Item i2= new Item();
		i2.setProductNum(4);
		i2.setProductName("test order casacade2");
		i2.setProductId(2);
		i2.setProductNum(5);
		i2.setOrder(o);
		o.getItems().add(i1);
		o.getItems().add(i2);
		
		HibernateOrderDao odao = new HibernateOrderDao();
	    odao.saveOrder(o);
	    t.commit();

	}
}
