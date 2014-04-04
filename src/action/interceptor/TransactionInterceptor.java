package action.interceptor;



import org.hibernate.Transaction;

import util.HibernateUtil;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor  extends AbstractInterceptor{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
  public String intercept(ActionInvocation invocation) throws Exception {

    Transaction tx = HibernateUtil.getSession().beginTransaction();
    try{

      String resultCode = invocation.invoke();
      
      tx.commit();
      System.out.println("hibernate commit!");
      return resultCode;
    }catch(Exception ex){
      ex.printStackTrace();
      tx.rollback();
      throw ex;
    }finally{
      HibernateUtil.close();
    }
    
    
  }

}
