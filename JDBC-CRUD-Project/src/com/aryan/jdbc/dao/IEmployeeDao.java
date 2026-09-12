package com.aryan.jdbc.dao;

import java.util.List;

import com.aryan.jdbc.model.Employee;

public interface IEmployeeDao {
	public int saveEmployee(Employee employee);
	public Employee readById(int id);
	public List<Employee> readALL();
	public int update(Employee e);
	public int delete(int id);
}
