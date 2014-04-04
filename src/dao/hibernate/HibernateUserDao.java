package dao.hibernate;



import org.hibernate.Query;

import util.HibernateUtil;

import dao.UserDao;

import entity.User;

public class HibernateUserDao implements UserDao {

	public String findEmailVCodeById(int id) throws Exception {
		String hql = "from User where id=?";
		Query query= HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0,id);
		User u=(User)query.uniqueResult();
		return u.getEmailVerifyCode();
	}

	public User findUserByEmail(String email) throws Exception {
		String hql="from User where email=?";
		Query query=HibernateUtil.getSession().createQuery(hql);
		query.setString(0, email);
		User u=(User) query.uniqueResult();
		return u;
	}

	public User findUserById(int id) throws Exception {
		String hql="from User where id=?";
		Query query= HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0,id);
		User u=(User)query.uniqueResult();
		return u;
	}

	public void save(User user) throws Exception {
		HibernateUtil.getSession().save(user);
	}

	public void updateEmailVerifyStatus(int id, boolean status) throws Exception {
		String hql="from User where id=?";
		Query query= HibernateUtil.getSession().createQuery(hql);
		query.setInteger(0,id);
		User u=(User)query.uniqueResult();
		u.setEmailVerify(status);
	}

	public void updateLastLoginIp(int id, String ip) throws Exception {
		User u=findUserById(id);
		u.setLastLoginIp(ip);
		
	}

	

	
}
