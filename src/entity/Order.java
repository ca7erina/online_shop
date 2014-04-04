package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 577677263286623790L;
	int id;
	int status;
	long ordertime;
	String orderdesc;
	Double totalPrice;
	
	private Set<Item> items =new HashSet<Item>();
	DeliverInfo deliverInfo = new DeliverInfo();

	
	public DeliverInfo getDeliverInfo() {
		return deliverInfo;
	}
	public void setDeliverInfo(DeliverInfo deliverInfo) {
		this.deliverInfo = deliverInfo;
	}
	public String getOrderdesc() {
		return orderdesc;
	}
	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}
	public long getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(long ordertime) {
		this.ordertime = ordertime;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}




	
}
