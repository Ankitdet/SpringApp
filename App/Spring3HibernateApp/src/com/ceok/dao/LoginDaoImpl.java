package com.ceok.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceok.db.DBOperation;
import com.ceok.model.Login;

/**
 * @author ankit detroja
 *
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private DBOperation dbOperation ;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isValidaUser(Login user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Login> listEmployeess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Login employee) {
		// TODO Auto-generated method stub
		
	}

}
