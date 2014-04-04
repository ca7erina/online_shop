package action.cart;



import action.BaseAction;
import dao.hibernate.HibernateProductDao;
import entity.CartItem;



public class BuyAction extends BaseAction{

	private int productId;
	private boolean added = false;//output-->json
	
	public String execute() throws Exception {
		Cart cart= (Cart)session.get("cart");
		
		CartItem item= new CartItem(new HibernateProductDao().findProductById(productId));
		if(cart==null){
			cart=new Cart();
			cart.add(item);
			session.put("cart", cart);
			added= true;
			System.out.println("buy action: "+added+" productId"+ productId);
			return "success";
			
		}else{
			added=cart.add(item);
			session.put("cart", cart);
			System.out.println("buy action: "+added+" productId"+ productId);
			return "success";
		}
		
		
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
