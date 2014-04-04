package action.interceptor;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;




import action.cart.Cart;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


import entity.CartItem;


public class RemoveCartInCookie extends AbstractInterceptor {

	
	
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//before action
		String result=invocation.invokeActionOnly();
		//System.out.println("1test get result :"+invocation.getResult());
		
		//after action
		Cookie c= new Cookie("cart","");
		c.setMaxAge(0);
		c.setPath("/");
		ServletActionContext.getResponse().addCookie(c);
		System.out.println("cart null in cookie ");
	//	System.out.println("2test get result :"+invocation.getResult());
		return "success";

	}

}
