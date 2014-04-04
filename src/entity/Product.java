package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productname;
	private String description;
	private Long addtime;
	private double fixedprice;
	private double dangprice;
	private String keywords;
	private int hasdeleted;
	private String productpic;
	private Set<Category> cats = new HashSet<Category>();
	private Book book;
	public Product(){
		
	}
	public Product(Integer id,String productname,String description,Long addtime,double fixedprice,double dangprice,String keywords,int hasdeleted,String productpic){
		this.id=id;
		this.productname=productname;
		this.description=description;
		this.addtime=addtime;
		this.fixedprice=fixedprice;
		this.dangprice=dangprice;
		this.keywords=keywords;
		this.hasdeleted=hasdeleted;
		this.productpic=productpic;
	}
	public String toString(){

		return id+":"+productname+":"+description+":"+addtime+":"+fixedprice+":"+dangprice+":"+keywords+":"+hasdeleted+":"+productpic;
		
	}
	public Long getAddtime() {
		return addtime;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Set<Category> getCats() {
		return cats;
	}
	public void setCats(Set<Category> cats) {
		this.cats = cats;
	}
	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

	public double getDangprice() {
		return dangprice;
	}

	public void setDangprice(double dangprice) {
		this.dangprice = dangprice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFixedprice() {
		return fixedprice;
	}

	public void setFixedprice(double fixedprice) {
		this.fixedprice = fixedprice;
	}



	public int getHasdeleted() {
		return hasdeleted;
	}

	public void setHasdeleted(int hasdeleted) {
		this.hasdeleted = hasdeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductpic() {
		return productpic;
	}

	public void setProductpic(String productpic) {
		this.productpic = productpic;
	}

	
}
