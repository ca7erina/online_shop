package test;

import dao.JdbcOrderDao;
import entity.DeliverInfo;
import entity.Order;


public class TestDao {



	public static void main(String[] args){
//		JdbcUserDao a = new JdbcUserDao();
//		User u = new User("123123","a@gl.com","kitty",20,"127.0.0.1");
//		try {
//			a.save(u);
//			a.findUserByEmail("email");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("test".indexOf("-"));
		
//		JdbcCategoryDao dao= new JdbcCategoryDao();
//		
//		try {
//			dao.findSubCategory(1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JdbcProductDao dao= new JdbcProductDao();
//			try {
//				dao.findNewProduct(System.currentTimeMillis()-1000*3600*24*7);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1237873000234l)));
//			System.out.println(System.currentTimeMillis());
//			JdbcBookDao dao= new JdbcBookDao();
//			try {
//				System.out.println(dao.getPageBreakProductByCtgy(2, 1, 5).size());;
//				
//			} catch (Exception e) {
//			
//				e.printStackTrace();
//			}
//			try {
//				System.out.println(dao.findAll().size());
//				System.out.println(dao.getTotalPage(9, 5));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			JdbcOrderDao dao= new JdbcOrderDao();
			DeliverInfo d= new DeliverInfo();
			d.setFulladdress("sssss");
			d.setMobile("1123123");
			d.setPhone("123123123");
			d.setPostalcode("sdfsdf");
			d.setReceivename("sdfsdf");
			d.setUserid(1);
//			try {
//				dao.saveDeliverInfo(d);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			Order o= new Order();
			o.setDeliverInfo(d);
			o.setOrderdesc("sgdfsdf");
			o.setOrdertime(System.currentTimeMillis());
			o.setStatus(1);
			o.setTotalPrice(123.123);
	//		o.setUserid(1);
			try {
				dao.saveOrder(o);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	

}
