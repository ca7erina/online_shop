package test;

import action.BaseAction;

public class VerifyAction extends BaseAction{

	  private String hint= "";//output-->json
	  
	  public String execute() throws Exception{
	    
	    String scode = (String)session.get("code");
	    
	      hint = scode;
	   
	    return "success";//调用jsonResult输出ok
	  }

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
	  
	 

	  
	  
	  
	
}
