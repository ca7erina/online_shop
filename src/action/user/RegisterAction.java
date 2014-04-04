package action.user;

import util.Constant;
import util.EmailUtil;
import util.MD5Util;
import util.VerifyUtil;
import action.BaseAction;

import dao.UserDao;
import dao.hibernate.HibernateUserDao;
import entity.User;

public class RegisterAction extends BaseAction {
	private User user=new User();
	private String emailVerifyCode;
	UserDao dao= new HibernateUserDao();
	public String execute() throws Exception{
		System.out.println("before user:"+user);
		System.out.println("get a register user:"+user);
		user.setUserIntegral(Constant.LEVEL1);
		user.setPassword(MD5Util.getString(user.getPassword()));
		
		user.setEmailVerify(false);
		user.setLastLoginTime(System.currentTimeMillis());
		user.setLastLoginIp(httpRequest.getRemoteAddr());
		String verifyCode = VerifyUtil.createVerifyCode(); 
		user.setEmailVerifyCode(verifyCode);
		
		dao.save(user);
		emailVerifyCode=verifyCode+"-"+user.getId();
		EmailUtil.sendEmail(user.getEmail(),emailVerifyCode);
		System.out.println("after user:"+user);
		return "verify";
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	
}
