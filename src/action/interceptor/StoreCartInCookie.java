package action.interceptor;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;




import action.cart.Cart;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


import entity.CartItem;


public class StoreCartInCookie extends AbstractInterceptor {

	
	
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String ,Object> session = invocation.getInvocationContext().getSession();
		Cart cart =(Cart) session.get("cart");
		if(cart!=null){
		StringBuffer sb= new StringBuffer();
		for(CartItem i:cart.getBuy()){
			sb.append(i.toString()+",");
		}
		System.out.println("sb:"+sb.toString());
		Cookie c= new Cookie("cart", URLEncoder.encode(sb.toString(),"utf-8"));
		c.setMaxAge(3600*72);
		c.setPath("/");
		
		ServletActionContext.getResponse().addCookie(c);
		System.out.println("cart stored in cookie :"+sb.toString());
		}
		
		return invocation.invoke();

	}

}
