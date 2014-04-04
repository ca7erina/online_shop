package entity;




public class Item implements java.io.Serializable {

	// Fields


	private static final long serialVersionUID = 1L;

	private Integer id;
	
	//private Integer orderId;
  //追加属性,存储相关Order表的记录
  private Order order;

	private Integer productId;

	private String productName;

	private double dangPrice;

	private Integer productNum;

	private double amount;

	// Constructors

	/** default constructor */
	public Item() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getDangPrice() {
		return this.dangPrice;
	}

	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public Integer getProductNum() {
		return this.productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }



} 