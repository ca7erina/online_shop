package action.user;

import util.MD5Util;
import action.BaseAction;
//import dao.JdbcUserDao;
import dao.UserDao;
import dao.hibernate.HibernateUserDao;
import entity.User;

public class LoginAction extends BaseAction {
	private User user=new User();
	private String email;
	private String password;
	private String loginerror;
	//UserDao dao=new JdbcUserDao();
	UserDao dao=new HibernateUserDao();
	public String execute() throws Exception{
		
		user=dao.findUserByEmail(email);
		if (user==null){
			loginerror= "用户名或密码错误。";
			System.out.println("login Info dosen't match :"+email+password);
			return "fail";
		}
		if(user.getPassword().equals(MD5Util.getString(password))){
			System.out.println("login Info matches!:"+user);
			if(!user.getEmailVerify()){
				return "verify";
			}
			dao.updateLastLoginIp(user.getId(), httpRequest.getRemoteAddr());
			session.put("user", user);
			return "success";
		}
		
		System.out.println("login Info dosen't match!");
		return "fail";
		
		
		
	}

	public String getLoginerror() {
		return loginerror;
	}

	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
