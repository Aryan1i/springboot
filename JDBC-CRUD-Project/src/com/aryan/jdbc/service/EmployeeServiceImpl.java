package com.aryan.jdbc.service;

import java.util.List;

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
	
	public Employee readById(int id) {
		IEmployeeDao dao = new EmployeeDaoImpl();
		return dao.readById(id);
	} 
	
	public List<Employee> readALL() {
		IEmployeeDao dao = new EmployeeDaoImpl();
		
		return dao.readALL();
	}
	
	public boolean update(Employee e) {
		IEmployeeDao dao = new EmployeeDaoImpl();
		return dao.update(e) == 1;
	}
	
	public boolean delete(int id) {
		IEmployeeDao dao = new EmployeeDaoImpl();
		return dao.delete(id) == 1;
	}

}