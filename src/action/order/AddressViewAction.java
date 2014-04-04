package action.order;



import java.util.ArrayList;

import java.util.List;

import action.BaseAction;
import dao.JdbcOrderDao;
import dao.OrderDao;
import entity.DeliverInfo;
import entity.User;

public class AddressViewAction extends BaseAction{
	List<DeliverInfo> addresses=new ArrayList<DeliverInfo>();
	 OrderDao dao=new JdbcOrderDao();
 public String execute() throws Exception{
	 User u= (User)session.get("user");
		
		addresses=dao.getDeliverInfoByUid(u.getId());
		System.out.println("return user's addr:"+addresses);
		 return "success";
	

 }

public List<DeliverInfo> getAddresses() {
	return addresses;
}

public void setAddresses(List<DeliverInfo> addresses) {
	this.addresses = addresses;
}


}
