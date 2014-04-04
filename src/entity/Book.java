package entity;



import java.io.Serializable;
import java.util.Date;

public class Book extends Product implements Serializable{
  /**
	 * 
	 */
   	  private static final long serialVersionUID = 1L;
	  private Integer id;
	  private String author;
	  private String publishing;
	  private Long publishTime;
	  private String wordNumber;
	  private String edition;
	  private Long printtime;
	  private String printnumber;
	  private int totalPage;
	  private String isbn;
	  private String summary;
	  private String catalogue;
	  private Product product;
	  public Book() {
		  
	  }
  
  public String toString(){
	  
	  
	return id+":"+author+":"+publishing+":"+publishTime +":"+wordNumber +":"+edition+":"+ totalPage +":"+isbn +":"+summary +":"+catalogue;
	  
  }
  
  


public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public String getPrintnumber() {
	return printnumber;
}

public void setPrintnumber(String printnumber) {
	this.printnumber = printnumber;
}

public Long getPrinttime() {
	return printtime;
}

public void setPrinttime(Long printtime) {
	this.printtime = printtime;
}

public String getCatalogue() {
	return catalogue;
}

public void setCatalogue(String catalogue) {
	this.catalogue = catalogue;
}

public String getEdition() {
	return edition;
}

public void setEdition(String edition) {
	this.edition = edition;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public String getSummary() {
	return summary;
}

public void setSummary(String summary) {
	this.summary = summary;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public Date getPublishingDt(){
    return new Date(publishTime);
  }
  
  
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getPublishing() {
    return publishing;
  }
  public void setPublishing(String publishing) {
    this.publishing = publishing;
  }
  public Long getPublishTime() {
    return publishTime;
  }
  public void setPublishTime(Long publishTime) {
    this.publishTime = publishTime;
  }
  public String getWordNumber() {
    return wordNumber;
  }
  public void setWordNumber(String wordNumber) {
    this.wordNumber = wordNumber;
  }
  
}
