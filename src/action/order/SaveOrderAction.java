package action.order;



import service.CaculatePrice;
import dao.JdbcOrderDao;
import dao.OrderDao;
import dao.hibernate.HibernateOrderDao;
import entity.DeliverInfo;
import entity.Order;

import entity.User;
import action.BaseAction;
import action.cart.Cart;

public class SaveOrderAction extends BaseAction{
	private DeliverInfo deliverinfo = new DeliverInfo();
	private double totalPrice;
	private int orderid;
	OrderDao odao= new HibernateOrderDao();
 public String execute() throws Exception{
	 
	 Cart cart= (Cart)session.get("cart");
	 
	 User user=(User)session.get("user");
	 
		
		 deliverinfo.setUserid(user.getId());
		
		 if(deliverinfo.getId()==-1){
			 odao.saveDeliverInfo(deliverinfo); 
		 }else{
			 
			 odao.updateDeliverInfo(deliverinfo);
		 }

		 Order order= new Order();
		 order.setDeliverInfo(deliverinfo);
		 order.setOrderdesc("");
		 //order.setUserid(user.getId());
		 totalPrice=new CaculatePrice().getTotalPrice(cart);
		 order.setTotalPrice(totalPrice);
		 orderid=odao.saveOrder(order);
		 System.out.println("order saved"+order);
		 odao.saveCartItem(cart, orderid);
		 //session.remove("cart");
		return "success";
	 
	
	 
 }
public DeliverInfo getDeliverinfo() {
	return deliverinfo;
}
public void setDeliverinfo(DeliverInfo deliverinfo) {
	this.deliverinfo = deliverinfo;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}


}
