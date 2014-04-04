package action.user;

import action.BaseAction;

public class VerifyAction extends BaseAction{
	private String code;//input
	  
	  private boolean ok = false;//output-->json
	  
	  public String execute() throws Exception{
	    Thread.sleep(1000);
	    //比较
	    String scode = ((String)session.get("code"));
	    System.out.println("session code:"+scode);
	    System.out.println("userinput code:"+code);
	    code=code.substring(0, 5);
	    if(code.equals(scode)){
	      ok = true;
	    }else{
	    	
	      ok = false;
	    }
	    System.out.println("return ok:"+ok);
	    return "success";//调用jsonResult输出ok
	  }
	  
	  public String getCode() {
	    return code;
	  }

	  public void setCode(String code) {
	    this.code = code;
	  }

	  public boolean isOk() {
	    return ok;
	  }

	  public void setOk(boolean ok) {
	    this.ok = ok;
	  }

	  
	  
	  
	
}
