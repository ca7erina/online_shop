package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
 public static void close(ResultSet rs){
	 if(rs!=null){
		 try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 public static void close(Statement st){
	 if(st!=null){
		 try{
			 st.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
 }
 public static void close(Connection con){
	 if(con!=null){
		 try{
			 con.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
 }
 public static void close(ResultSet rs,Statement st){
	close(rs);
	 close(st);
 }
 
 public static void close(Statement st,Connection con){
		close(st);
		close(con);
 }
 
 public static void close(ResultSet rs,Statement st,Connection con){
		close(rs);
		close(st,con);
 }
}
