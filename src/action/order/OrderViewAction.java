package action.order;



import service.CaculatePrice;
import action.BaseAction;
import action.cart.Cart;

public class OrderViewAction extends BaseAction{
 private double totalPrice;
 
 public String execute() throws Exception{
	 Cart cart= (Cart)session.get("cart");
	 if(!cart.equals(null)){
		 totalPrice=new CaculatePrice().getTotalPrice(cart);
		 return "success";
	 }else{
		 return "fail";
	 }
	 
	 
 }

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}


}
