package dao;

import java.util.List;

import action.cart.Cart;

import entity.DeliverInfo;
import entity.Order;

public interface OrderDao {
	
	public List<DeliverInfo> getDeliverInfoByUid(int Userid) throws Exception ;
	public int saveDeliverInfo(DeliverInfo info) throws Exception ;
	public int updateDeliverInfo(DeliverInfo info) throws Exception ;
	public int saveOrder(Order order) throws Exception;
	public int saveCartItem(Cart cart,int OrderId) throws Exception;
}
