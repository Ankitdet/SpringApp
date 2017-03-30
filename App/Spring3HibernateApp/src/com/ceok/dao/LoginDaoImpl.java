package com.ceok.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceok.bean.LoginBean;
import com.ceok.model.Login;

/**
 * @author Dinesh Rajput
 *
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean isValidaUser(Login user) {
		
		Session session = sessionFactory.getCurrentSession();
		try{
			String str = "select count(*) from Login l where l.username=:username and l.password=:password";
			Query query = session.createQuery(str);
			query.setString("username", user.getUsername());
			query.setString("password", user.getPassword());
			Long count = (Long)query.uniqueResult();
			if(count > 0) return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Login> listEmployeess() {
		return (List<Login>) sessionFactory.getCurrentSession().createCriteria(Login.class).list();
	}

	public Login getEmployee(int userId) {
		return (Login) sessionFactory.getCurrentSession().get(Login.class, userId);
	}

	public void deleteEmployee(Login users) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Login WHERE id = "+users.getId()).executeUpdate();
	}

}
