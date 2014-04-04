package action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import entity.User;

public class ClearSessionInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		ActionContext ac=invocation.getInvocationContext();
		ac.getSession();
		
		Map<String ,Object> session = ac.getSession();
		session.clear();
			return invocation.invoke();
		
		

	}

	

}
