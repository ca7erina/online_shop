package action.cart;



import action.BaseAction;
import dao.hibernate.HibernateProductDao;
import entity.Product;



public class ModifyAction extends BaseAction{

	private int productId;
	private int newQty;
	private boolean modified;
	private Product product;

	public String execute() throws Exception {
		product=new HibernateProductDao().findProductById(productId);
		Cart cart= (Cart)session.get("cart");
			modified=cart.modify(productId,newQty);
			
			session.put("cart", cart);
			
			System.out.println("modify action-> productId "+ productId);
			System.out.println("modify action-> newQty "+ newQty);
			return "success";
		}
		








	


	public Product getProduct() {
		return product;
	}












	public void setProduct(Product product) {
		this.product = product;
	}












	public boolean isModified() {
		return modified;
	}



	public void setModified(boolean modified) {
		this.modified = modified;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}



	public int getNewQty() {
		return newQty;
	}



	public void setNewQty(int newQty) {
		this.newQty = newQty;
	}
		


}
