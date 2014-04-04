package entity;

import java.io.Serializable;




/**
 * a helper for adding products.
 * @author soft01
 *
 */
public class CartItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8814844321030041559L;
	private int id;

	private Product product;
	private int qty;
	private Order order;
	


	public CartItem(){
		
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CartItem(Product product){
		this.product=product;
		this.qty=1;
	}
	public CartItem(Product product,int qty){
		this.product=product;
		this.qty=qty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String toString(){
		return qty+"-"+product;
	}
}
