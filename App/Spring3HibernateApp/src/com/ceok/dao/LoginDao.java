package com.ceok.dao;

import java.util.List;

import com.ceok.model.Login;

/**
 * @author ankit detroja
 *
 */
public interface LoginDao {
	
	public boolean isValidaUser(Login user);

	public List<Login> listEmployeess();
	
	public Login getEmployee(int empid);
	
	public void deleteEmployee(Login employee);
}
