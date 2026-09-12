package com.aryan.jdbc.service;

import java.util.List;
import com.aryan.jdbc.model.Employee;

public interface IEmployeeService {
	boolean saveEmployee(Employee employee);
	public Employee readById(int id);
	public List<Employee> readALL();
	public boolean update(Employee e);
	public boolean delete(int id);
}
