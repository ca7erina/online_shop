package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;



public class HibernateUtil {
	  private static SessionFactory sf;
	  //用来存储与当前线程对应的Session对象
	  private static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	  
	  static{
	    //加载Hibernate主配置及映射信息
	    Configuration conf = new Configuration();
	    //默认加载src目录下
	    conf.configure("/hibernate.cfg.xml");
	    //获取SessionFactory
	    sf = conf.buildSessionFactory();
	  }
	  
	  public static Session getSession(){
	    //从ThreadLocal中获取
	    Session session = sessionLocal.get();
	    //如果获取不到
	    if(session == null){
	      //获取一个新创建的Session对象
	      session = sf.openSession();
	      //将session放入ThreadLocal
	      sessionLocal.set(session);
	    }
	    return session;
	  }
	  
	  public static void close(){
	    //从ThreadLocal中获取
	    Session session = sessionLocal.get();
	    sessionLocal.set(null);
	    if(session != null && session.isOpen()){
	      session.close();
	    }
	  }
	  
	  
	}
