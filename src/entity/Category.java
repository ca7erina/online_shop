package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category implements Serializable{
	private static final long serialVersionUID = -1209682050981877025L;
	private Integer id;
	private Integer turn;
	private String enname;
	private String name;
	private String description;
	private Integer parentid;
	private List <Category> subCategories;
	private Integer pnum;
	private Set<Product> products = new HashSet<Product>();
	
	public Category(){
		
	}



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	

	public Integer getPnum() {
		return pnum;
	}



	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}



	public List<Category> getSubCategories() {
		return subCategories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	public String toString(){
		
		return id+":"+turn+":"+enname+":"+name+":"+description+":"+parentid+":"+subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
}
