package action.user;


import action.BaseAction;


public class LogoutAction extends BaseAction {

	 
	public String execute() throws Exception{
		session.clear();
		return "success";
		
		
		
	}


	
	
}
