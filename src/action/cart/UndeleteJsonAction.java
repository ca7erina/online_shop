package action.cart;



import action.BaseAction;
import dao.hibernate.HibernateProductDao;
import entity.Product;



public class UndeleteJsonAction extends BaseAction{

	private int productId;
	private Product product;//output-->json
	
	public String execute() throws Exception {
		Cart cart= (Cart)session.get("cart");
		cart.undelete(productId);
		session.put("cart", cart);
		product=new HibernateProductDao().findProductById(productId);
			return "success";

	}




	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}




	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
		


}
