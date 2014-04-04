package action.cart;




import dao.ProductDao;
import entity.CartItem;
import entity.Product;

import action.BaseAction;



public class UndeleteAction extends BaseAction{

	private int productId;
	private boolean added = false;//output-->json
	
	public String execute() throws Exception {
		Cart cart= (Cart)session.get("cart");
		cart.undelete(productId);
			return "success";

	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
		


}
