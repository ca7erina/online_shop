package action.user;


import dao.UserDao;
import dao.hibernate.HibernateUserDao;
/**
 * for test:http://localhost:8080/dangdang/user/checkEmail.action?email="test@test.com"
 * @author soft01
 *
 */
public class CheckEmailAction {

	private String email;//input
	 private boolean ok = false;//output-->json
	// UserDao dao = new JdbcUserDao();
	 UserDao dao = new HibernateUserDao();
	  public String execute() throws Exception{
		    Thread.sleep(1000);
		   
		    if(dao.findUserByEmail(email)==null){
		    	ok=true;
			   System.out.println("user input email : "+email);		 
			   System.out.println("checkEmailAction return okForReg:"+ok);
			    
	  		}//调用jsonResult输出ok
		    return "success";
		  }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}


	
	
	
	
	
}
