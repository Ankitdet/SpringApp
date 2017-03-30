package com.ceok.service;

import java.util.List;

import com.ceok.model.Login;

/**
 * @author Dinesh Rajput
 *
 */
public interface LoginService {
	
	public boolean isValidateUser(Login users);

	public List<Login> listEmployeess();
	
	public Login getEmployee(int empid);
	
	public void deleteEmployee(Login employee);
}
