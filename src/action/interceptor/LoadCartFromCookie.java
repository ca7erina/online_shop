package action.interceptor;

import java.net.URLDecoder;

import java.util.Arrays;


import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;






import action.cart.Cart;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import entity.CartItem;
import entity.Product;


public class LoadCartFromCookie extends AbstractInterceptor {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Cart cart=new Cart();
		Cookie cookies[]=ServletActionContext.getRequest().getCookies();
		if (cookies!=null){
		for(Cookie c:cookies){
			if(c.getName().equals("cart")){
				System.out.println("get cart from cookie");
				String strs=URLDecoder.decode(c.getValue(), "utf-8");
				System.out.println(strs);
				String[] item=strs.split(",");
				System.out.println(Arrays.toString(item));
				
				for (String i:item){
				String str[]=i.split("-");
				System.out.println("split by '-': "+Arrays.toString(str));
				String pro[]=str[1].split(":");
				System.out.println("split by ':': "+Arrays.toString(pro));
				CartItem ci= new CartItem();
				ci.setQty(Integer.parseInt(str[0]));
				ci.setProduct(new Product(Integer.parseInt(pro[0].trim()),pro[1].trim(),pro[2].trim(),Long.parseLong(pro[3].trim()),Double.parseDouble(pro[4].trim()),Double.parseDouble(pro[5].trim()),pro[6].trim(),Integer.parseInt(pro[7].trim()),pro[8].trim()));
				cart.add(ci);
				}
				
			}
			
		}
		
		System.out.println("cart loaded from cookie:"+cart);
		invocation.getInvocationContext().getSession().put("cart", cart);
		}
		return invocation.invoke();
		}
		

	}



	


