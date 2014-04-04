package util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
	public static void sendEmail(String emailAddr,String verifyCode){
		System.out.println("send mail to ->"+emailAddr+""+verifyCode);
	
		   
		    SimpleEmail email = new SimpleEmail();
		    email.setHostName("smtp.sina.com");
		    email.setAuthentication("cxxi_dts", "19620604");
		    email.setCharset("UTF-8");
		    try {
		      email.addTo(emailAddr);
		      email.setFrom("cxxi_dts@sina.com");//必须和Authentication使用的用户相同，否则失败
		      email.setSubject("邮箱验证码");
		      email.setMsg("恭喜您注册成功,邮箱验证码为"+verifyCode);
		      email.send();
		    } catch (EmailException e) {
		      e.printStackTrace();
		    }
		  }
}
