package action.user;

import util.Constant;
import util.EmailUtil;
import util.VerifyUtil;
import action.BaseAction;

import dao.UserDao;
import dao.hibernate.HibernateUserDao;
import entity.User;

public class EmailVerifyAction extends BaseAction {
	private User user=new User();
	private String emailVerifyCode;
	 
	public String execute() throws Exception{
		//UserDao dao= new JdbcUserDao();
		UserDao dao= new HibernateUserDao();
		System.out.println("/n user input emailcode:"+emailVerifyCode);
			String codes[]=emailVerifyCode.split("-");
			Integer id=Integer.valueOf(codes[codes.length-1]);
			user=dao.findUserById(id);
			String code=dao.findEmailVCodeById(id);
			System.out.println("/n database emailcode+id:"+code+"-"+id);
			if(emailVerifyCode.equals(code+"-"+id)){
				dao.updateEmailVerifyStatus(id, true);
				System.out.println("match");
				session.put("user", user);
				return "success";
			}
			request.put("verifyError", "<img src='../images/wrong.gif'/>验证码不正确.");
		System.out.println("doesn't match");
		return "fail";
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
