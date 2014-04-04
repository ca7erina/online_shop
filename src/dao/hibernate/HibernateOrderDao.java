package dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

import action.cart.Cart;

import util.HibernateUtil;
import dao.OrderDao;
import entity.CartItem;
import entity.DeliverInfo;
import entity.Order;
import entity.User;

public class HibernateOrderDao implements OrderDao {

	public List<DeliverInfo> getDeliverInfoByUid(int Userid) throws Exception {
		String hql="From DeliverInfo where userid=?";
		Query query= HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0,Userid);
		List<DeliverInfo> list=query.list();
		return list;
		
	}

	public int saveCartItem(Cart cart, int OrderId) throws Exception {
		
		return 0;
	}

	public int saveDeliverInfo(DeliverInfo info) throws Exception {
		HibernateUtil.getSession().save(info);
		return info.getId();
	}

	public int saveOrder(Order order) throws Exception {
		order.setOrdertime(System.currentTimeMillis());
		System.out.println(order);
		HibernateUtil.getSession().save(order);
		return order.getId();		
	}

	public int updateDeliverInfo(DeliverInfo info) throws Exception {
		HibernateUtil.getSession().update(info);
		return info.getId();
	}


	
	
}
