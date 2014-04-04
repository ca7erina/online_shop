package action.interceptor;

import java.util.Map;

import action.cart.Cart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import entity.User;

public class RemoveCartInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		String result=invocation.invokeActionOnly();
		Map<String ,Object> session = invocation.getInvocationContext().getSession();
		Cart cart=new Cart();
		session.put("cart", cart);
		System.out.println("cart removed in session");
		return "success";

	}

	

}
