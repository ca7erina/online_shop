package entity;

import java.util.HashSet;
import java.util.Set;

public class User {
private Integer id;
private String password;
private String email;
private String nickname;
private Integer userIntegral;
private Boolean emailVerify=false;
private String emailVerifyCode;
private Long lastLoginTime;
private String lastLoginIp;
private Set<DeliverInfo> deliverinfos=new HashSet<DeliverInfo>();

public User(){
	
}
public User(String password, String email, String nickname,int userIntegral,String lastLoginIp){
	this.password=password;
	this.email=email;
	this.nickname=nickname;
	this.userIntegral=userIntegral;
	this.lastLoginTime=System.currentTimeMillis();
	this.lastLoginIp=lastLoginIp;
	}
public String toString(){
	return id+":"+email+":"+nickname+":"+userIntegral+":"+emailVerify+":"+emailVerifyCode+":"+lastLoginTime+":"+lastLoginIp;
}


public Set<DeliverInfo> getDeliverinfos() {
	return deliverinfos;
}
public void setDeliverinfos(Set<DeliverInfo> deliverinfos) {
	this.deliverinfos = deliverinfos;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Boolean getEmailVerify() {
	return emailVerify;
}
public void setEmailVerify(Boolean emailVerify) {
	this.emailVerify = emailVerify;
}
public String getEmailVerifyCode() {
	return emailVerifyCode;
}
public void setEmailVerifyCode(String emailVerifyCode) {
	this.emailVerifyCode = emailVerifyCode;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getLastLoginIp() {
	return lastLoginIp;
}
public void setLastLoginIp(String lastLoginIp) {
	this.lastLoginIp = lastLoginIp;
}
public Long getLastLoginTime() {
	return lastLoginTime;
}
public void setLastLoginTime(Long lastLoginTime) {
	this.lastLoginTime = lastLoginTime;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public Integer getUserIntegral() {
	return userIntegral;
}
public void setUserIntegral(Integer userIntegral) {
	this.userIntegral = userIntegral;
}



}
