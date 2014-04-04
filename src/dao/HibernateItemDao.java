package dao;

import java.util.List;
import org.hibernate.Query;
import util.HibernateUtil;
import entity.CartItem;
import entity.Item;

public class HibernateItemDao implements ItemDao{

	public List<Item> FindItems() throws Exception {
		 String hql = "from CartItem";
		 Query query = HibernateUtil.getSession().createQuery(hql);
		List<Item> list = query.list();
		return list;
	}
	public List<Item> FindItemsByOrderId(int orderid) throws Exception {
		 String hql = "from Item item where item.order.id=?";
		 Query query = HibernateUtil.getSession().createQuery(hql);
		 query.setInteger(0, orderid);
		List<Item> list = query.list();
		return list;
	}

	public Item FindById(int itemId) throws Exception {
		 String hql = "from Item item join fetch item.order where item.id=?";
		 Query query= HibernateUtil.getSession().createQuery(hql);
		 query.setInteger(0,itemId);
		 Item item=(Item)query.uniqueResult();
		//Item item= (Item)HibernateUtil.getSession().get(Item.class, itemId);
		return item;
		
	}
	
}
