package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import action.cart.Cart;

import util.DbUtil;
import entity.CartItem;
import entity.DeliverInfo;
import entity.Order;
import entity.User;

public class JdbcOrderDao implements OrderDao{

	private final String saveCartItem="insert into d_item(order_id,product_id,product_name,dang_price,product_num,amount) values(?,?,?,?,?,?)";
	private final String savedeliverInfo="insert into d_receive_address(user_id,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?)";
	private final String saveOrder="insert into d_order(user_id,status,order_time,order_desc,total_price,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?,?,?,?,?)";
	private final String getDeliverInfo="select * from d_receive_address where user_id=?";
	private final String updateDeliverInfo="update d_receive_address set receive_name=?,full_address=?,postal_code=?,mobile=?,phone=? where id=?";
	public List<DeliverInfo> getDeliverInfoByUid(int userid) throws Exception {
		List<DeliverInfo> addresses=new LinkedList<DeliverInfo>();
		PreparedStatement pstm=DbUtil.getConnection().prepareStatement(getDeliverInfo);
		pstm.setInt(1, userid);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			DeliverInfo d= new DeliverInfo();
			d.setId(rs.getInt("id"));
			d.setUserid(userid);
			d.setReceivename(rs.getString("receive_name"));
			d.setFulladdress(rs.getString("full_address"));
			d.setPostalcode(rs.getString("postal_code"));
			d.setMobile(rs.getString("mobile"));
			d.setPhone(rs.getString("phone"));
			addresses.add(d);
			
		}
		return addresses;
	}

	public int saveDeliverInfo(DeliverInfo info) throws Exception {
		PreparedStatement pstm=DbUtil.getConnection().prepareStatement(savedeliverInfo,Statement.RETURN_GENERATED_KEYS);
		int index=1;
		pstm.setInt(index++, info.getUserid());
		pstm.setString(index++, info.getReceivename());
		pstm.setString(index++, info.getFulladdress());
		pstm.setString(index++, info.getPostalcode());
		pstm.setString(index++, info.getMobile());
		pstm.setString(index++, info.getPhone());
		pstm.executeUpdate();
		ResultSet rs= pstm.getGeneratedKeys();
		rs.next();
		int id=rs.getInt(1);
			info.setId(id);

		System.out.println("DeliverInfo added!");
		return id;
	}

	public int saveOrder(Order order) throws Exception {
		PreparedStatement pstm=DbUtil.getConnection().prepareStatement(saveOrder,Statement.RETURN_GENERATED_KEYS);
		int index=1;
		pstm.setInt(index++, order.getDeliverInfo().getUserid());
		pstm.setInt(index++, order.getStatus());
		pstm.setLong(index++, order.getOrdertime());
		pstm.setString(index++, order.getOrderdesc());
		pstm.setDouble(index++, order.getTotalPrice());
		pstm.setString(index++, order.getDeliverInfo().getReceivename());
		pstm.setString(index++, order.getDeliverInfo().getFulladdress());
		pstm.setString(index++, order.getDeliverInfo().getPostalcode());
		pstm.setString(index++, order.getDeliverInfo().getMobile());
		pstm.setString(index++, order.getDeliverInfo().getPhone());
		pstm.executeUpdate();
		ResultSet rs= pstm.getGeneratedKeys();
		rs.next();
		int orderid=rs.getInt(1);
			
			order.setId(orderid);
		System.out.println("order saved: "+order.getDeliverInfo().getUserid()+" "+order);
		return orderid;
		
	}

	public int updateDeliverInfo(DeliverInfo info) throws Exception {
		System.out.println(info);
		PreparedStatement pstm=DbUtil.getConnection().prepareStatement(updateDeliverInfo);
		int index=1;
		pstm.setString(index++, info.getReceivename());
		pstm.setString(index++, info.getFulladdress());
		pstm.setString(index++, info.getPostalcode());
		pstm.setString(index++, info.getMobile());
		pstm.setString(index++, info.getPhone());
		pstm.setInt(index++, info.getId());
		pstm.executeUpdate();
		System.out.println("address updated");
		return 0;
	}

	public int saveCartItem(Cart cart ,int OrderId) throws Exception {
		
		List<CartItem> buy=cart.getBuy();
		
		for(CartItem c:buy){
		PreparedStatement pstm=DbUtil.getConnection().prepareStatement(saveCartItem);
		int index=1;
		pstm.setInt(index++, OrderId);
		pstm.setInt(index++, c.getProduct().getId());
		pstm.setString(index++, c.getProduct().getProductname());
		pstm.setDouble(index++, c.getProduct().getDangprice());
		pstm.setInt(index++,c.getQty());
		pstm.setDouble(index++,c.getQty()*c.getProduct().getDangprice() );
		pstm.executeUpdate();
		}
		return 0;
	}
	
	
	
}
