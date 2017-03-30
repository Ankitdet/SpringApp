package com.ceok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ceok.dao.LoginDao;
import com.ceok.model.Login;

/**
 * @author Dinesh Rajput
 *
 */
@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean isValidateUser(Login users) {
		return loginDao.isValidaUser(users);
	}
	
	public List<Login> listEmployeess() {
		return loginDao.listEmployeess();
	}

	public Login getEmployee(int empid) {
		return loginDao.getEmployee(empid);
	}
	
	public void deleteEmployee(Login users) {
		loginDao.deleteEmployee(users);
	}

}
