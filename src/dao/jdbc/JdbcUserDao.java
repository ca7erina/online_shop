package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDao;


import util.DbUtil;
import entity.User;

public class JdbcUserDao implements UserDao{
	private static final String save= 
	"insert into d_user " +
    "(email,nickname,password," +
    "user_integral,is_email_verify," +
    "email_verify_code,last_login_time," +
    "last_login_ip) " +
    "values (?,?,?,?,?,?,?,?)";;
	
	public void save (User user) throws Exception{
		PreparedStatement pst=DbUtil.getConnection().prepareStatement(save,Statement.RETURN_GENERATED_KEYS);
		int index=1;
		pst.setString(index++, user.getEmail());
		pst.setString(index++, user.getNickname());
		pst.setString(index++, user.getPassword());
		pst.setInt(index++, user.getUserIntegral());
		
		pst.setString(index++, user.getEmailVerify()?"Y":"N");
		pst.setString(index++, user.getEmailVerifyCode());
		pst.setLong(index++, user.getLastLoginTime());
		pst.setString(index++, user.getLastLoginIp());
		pst.executeUpdate();
		ResultSet rs= pst.getGeneratedKeys();
		rs.next();
//		System.out.println(rs.getInt(1));
		user.setId(rs.getInt(1));
		
	}
	
	public void updateEmailVerifyStatus(int id ,boolean status) throws SQLException, Exception{
		String modify= status?"Y":"N";
		PreparedStatement pst= DbUtil.getConnection().prepareStatement("update d_user set is_email_verify=?  where id = ?");
		pst.setString(1, modify);
		pst.setInt(2, id);
		int rs=pst.executeUpdate();
		
		
	}
	
	public void updateLastLoginIp(int id ,String ip) throws SQLException, Exception{
		
		PreparedStatement pst= DbUtil.getConnection().prepareStatement("update d_user set last_login_time=?,last_login_ip=? where id = ?");
		pst.setLong(1, System.currentTimeMillis());
		pst.setString(2, ip);
		pst.setInt(3, id);
		int rs=pst.executeUpdate();
		
		
	}
	public User findUserByEmail(String email) throws SQLException, Exception{
		User u= new User();
		PreparedStatement pst= DbUtil.getConnection().prepareStatement("select * from d_user where email = ?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			u.setId(rs.getInt("id"));
			u.setEmail(rs.getString("email"));
			u.setNickname(rs.getString("nickname"));
			u.setPassword(rs.getString("password"));
			u.setUserIntegral(rs.getInt("user_integral"));
			u.setEmailVerify(rs.getString("is_email_verify").equals("Y")? true:false);
			u.setEmailVerifyCode(rs.getString("email_verify_code"));
			u.setLastLoginIp(rs.getString("last_login_ip"));
			u.setLastLoginTime(rs.getLong("last_login_time"));	
			System.out.println("User finded:"+u);
			return u;
		}
		System.out.println("User didn't find");
		return null;
			
		
		
	}
	
	
	public String findEmailVCodeById(int id) throws SQLException, Exception{
		String vcode="";
		PreparedStatement pst= DbUtil.getConnection().prepareStatement("select email_verify_code from d_user where id = ?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			vcode=rs.getString(1);
		}
		return vcode;
		
	}
	public User findUserById(int id) throws SQLException, Exception{
		User u= new User();
		PreparedStatement pst= DbUtil.getConnection().prepareStatement("select * from d_user where id = ?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			u.setId(id);
			u.setEmail(rs.getString("email"));
			u.setNickname(rs.getString("nickname"));
			u.setPassword(rs.getString("password"));
			u.setUserIntegral(rs.getInt("user_integral"));
			u.setEmailVerify(rs.getString("is_email_verify").equals("Y")? true:false);
			u.setEmailVerifyCode(rs.getString("email_verify_code"));
			u.setLastLoginIp(rs.getString("last_login_ip"));
			u.setLastLoginTime(rs.getLong("last_login_time"));	
			System.out.println("User finded:"+u);
			return u;
		}
		return null;
		
	}
	
	
}
