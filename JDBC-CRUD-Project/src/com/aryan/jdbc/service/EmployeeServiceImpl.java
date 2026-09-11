package com.aryan.jdbc.service;

import com.aryan.jdbc.dao.EmployeeDaoImpl;
import com.aryan.jdbc.dao.IEmployeeDao;
import com.aryan.jdbc.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
			 
	@Override
	public boolean saveEmployee(Employee employee) { 
		IEmployeeDao dao = new EmployeeDaoImpl();
		
		int result = dao.saveEmployee(employee); 
		
		return result > 0;
	}

}