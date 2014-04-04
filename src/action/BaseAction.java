package action;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.sun.org.apache.xpath.internal.operations.Number;




public class BaseAction implements SessionAware,RequestAware,ServletRequestAware{
	
	protected Map<String,Object> session;
	protected Map<String,Object> request;
	protected HttpServletRequest httpRequest;
	//protected Map<String,String> cookie;
	
	  public void setSession(Map<String, Object> arg0) {
		    this.session = arg0;
		  }

		  public void setRequest(Map<String, Object> arg0) {
		    this.request = arg0;
		  }

		  public void setServletRequest(HttpServletRequest arg0) {
		    this.httpRequest = arg0;
		  }

//		public void setCookiesMap(Map<String, String> arg0) {
//			// TODO Auto-generated method stub
//			
//		}

	

}

