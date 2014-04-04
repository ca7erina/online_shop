package util;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 
 * @author Administrator
 * 
 */
public final class DbUtil {
	private static DataSource ds;
	private static  ThreadLocal<Connection> connLocal= new ThreadLocal<Connection>();
	
	static{
		
		try {
			Properties props= new Properties();
			props.load(DbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			ds=BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception {
		Connection conn=connLocal.get();
		if(conn==null){
			conn=ds.getConnection();
			connLocal.set(conn);		
		}
		return conn;
	}

	public static void closeConnection() throws Exception {
		Connection conn=connLocal.get();
		connLocal.set(null);
		if(conn!=null&&!conn.isClosed()){
			conn.close();
		}
	}


	public static void main(String[] args) throws Exception {
		Connection conn=getConnection();
		System.out.println(conn.hashCode());
		Connection conn1=getConnection();
		System.out.println(conn1.hashCode());
		closeConnection();

	}

}
