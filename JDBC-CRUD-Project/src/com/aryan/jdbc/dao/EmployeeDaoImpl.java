package com.aryan.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aryan.jdbc.model.Employee;
import com.aryan.jdbc.utility.DBUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	public int saveEmployee(Employee employee) {
		Connection connection = null;
			
		try {
			connection =  DBUtil.getConnection();
			String sqlInsertQuery = "INSERT INTO employee (ename, esal, eaddr) VALUES (?, ?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlInsertQuery);
			
			pstmt.setString(1, employee.getEname());
			pstmt.setDouble(2, employee.getEsal());
			pstmt.setString(3, employee.getEaddr());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return 0;
	}
}
