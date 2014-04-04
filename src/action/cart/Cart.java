package action.cart;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.hibernate.HibernateProductDao;
import entity.CartItem;
import entity.Product;



public class Cart {

	/**
	 * a tool for connect computers with session.and included add, delect, list and calculatCost methods.
	 * @param args
	 */

	List<CartItem> buy = new ArrayList<CartItem>();
	List<CartItem> unbuy = new ArrayList<CartItem>();
	
	public boolean modify(int id, int qty) {
		int totalqty=100;
		for (CartItem i : buy) {
			if (i.getProduct().getId().equals(id)&&qty<totalqty) {
				i.setQty(qty);
				System.out.println("modify success");
				return true;
			}
				
				
			
		}
		
		return false;
	}
	public boolean add(CartItem item) {
		int count=0;

		if(unbuy.size()!=0){
			for (CartItem i : unbuy) {		
				if (i.getProduct().getId().equals(item.getProduct().getId()))	{	
					unbuy.remove(count);
					buy.add(i);
					System.out.println("add from undeleted list :"+i);
					return true;
				}
				count++;
				}		
		}
		if(buy.size()!=0){
			for (CartItem i : buy) {		
				if (i.getProduct().getId().equals(item.getProduct().getId()))	{	
					System.out.println("added false ,already bought :"+i);
					return false;
				}
				count++;
				}		
		}
		buy.add(item);
		System.out.println("added item"+item);
		return true;
	}



	public boolean delete(int id) {
		int count=0;
		for (CartItem i : buy) {
			
			if (i.getProduct().getId().equals(id))	{	
				buy.remove(count);
				System.out.println("deleted :"+i);
				unbuy.add(i);
				return true;
			}
			count++;
		}
		System.out.println("deleted fail");
		return false;
	}
	public boolean undelete(int id) {
		int count=0;
		for (CartItem i : unbuy) {
			if (i.getProduct().getId().equals(id))	{	
				unbuy.remove(count);
				System.out.println("unbuy deleted :"+i);
				buy.add(i);
				System.out.println("buy added :"+i);
				return true;
			}
			count++;
		}
		System.out.println("deleted fail unbuylist:" +unbuy);
		System.out.println("deleted fail id:" +id);
		return false;
	}
	
	
	public String store(){
		if(buy.size()==0&&unbuy.size()==0){
			return "0";
		}
		
		StringBuffer sb=new StringBuffer();
		for (CartItem i:buy){
			sb.append(i.getProduct().getId()+","+i.getQty()+";");

		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println("cookie saved:"+sb);
		return sb.toString();
		
	}
	
	
	public void loadStore(String content){
		ProductDao dao= new HibernateProductDao();
		if (content==null||content.equals("0")){
			return ;
		}
		String[] cartItemStr=content.split(";");
		for(String s:cartItemStr){
		String items[]=s.split(",");
		int id= Integer.parseInt(items[0]);
		int qty= Integer.parseInt(items[1]);
		
		CartItem i=new CartItem(); 
		i.setQty(qty);
		
		try {
			Product c = dao.findProductById(id);
			i.setProduct(c);
		this.buy.add(i);
		System.out.println("cookie loaded:"+items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
		
		
	}
	
	public List<CartItem> getBuy() {
		return buy;
	}
	public void setBuy(List<CartItem> buy) {
		this.buy = buy;
	}
	public List<CartItem> getUnbuy() {
		return unbuy;
	}
	public void setUnbuy(List<CartItem> unbuy) {
		this.unbuy = unbuy;
	}


}
