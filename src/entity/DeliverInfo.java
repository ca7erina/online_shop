package entity;

public class DeliverInfo {
	int id;
	int userid;
	String receivename;
	String fulladdress;
	String postalcode;
	String mobile;
	String phone;
	
	public String toString(){
		return id+" "+userid+" "+receivename+" "+fulladdress+" "+postalcode+" "+mobile+" "+phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFulladdress() {
		return fulladdress;
	}
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
