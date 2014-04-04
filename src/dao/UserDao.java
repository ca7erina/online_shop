package dao;





import entity.User;

public interface UserDao {
	 public void save(User user) throws Exception;
	 public User findUserByEmail(String email) throws Exception;
	 public String findEmailVCodeById(int id) throws Exception;
	 public void updateEmailVerifyStatus(int id ,boolean status) throws Exception;
	 public User findUserById(int id) throws Exception;
	 public void updateLastLoginIp(int id ,String ip) throws Exception;
}
