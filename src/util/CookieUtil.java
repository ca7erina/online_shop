package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;



/**
 * cookie utility includes creat(); find(); delete();
 */
public class CookieUtil {

	private  static String path = "/shoppingcart";
	private static int age=3600*24*3;
	/**
	 * Add cookie ,already change the code to utf-8;
	 * @param name
	 * @param value
	 * @param response
	 * @param age
	 * @param path
	 * @throws UnsupportedEncodingException 
	 */
	
	public static void addCookie(String name,String value,HttpServletResponse response,int age ,String path) throws UnsupportedEncodingException{
		Cookie c= new Cookie(name,URLEncoder.encode(value,"utf-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
		System.out.println("cookie created");
	}
	public static void addCookie(String name,String value,HttpServletResponse response) throws UnsupportedEncodingException{
		addCookie(name,value,response,age,path);
	}
	/**
	 * If the name dosen't exist ,return null;
	 * @param name
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException{
		Cookie cookies[]=request.getCookies();
		if(cookies!=null){
			for(Cookie c:cookies){
				if (name.equals(c.getName())){
					System.out.println("cookie finded");
					return URLDecoder.decode(c.getValue(),"utf-8");
				}
			}
		}
		System.out.println("cookie  unfind");
		return null;
		
	}
	
	public static void delete(String name,HttpServletResponse res){
		Cookie c =new Cookie(name,"");
		c.setMaxAge(0);
		c.setPath(path);
		res.addCookie(c);
		System.out.println("cookie deleted");
		
	}

	public static void main(String[] args) {
		

	}

}
