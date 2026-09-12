package com.aryan.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public Employee readById(int id) {
		Connection connection = null;
		
		try {
			connection =  DBUtil.getConnection();
			String sqlSelectQuery = "SELECT * FROM employee WHERE eid = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlSelectQuery);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				int eid = rs.getInt(1);
				String name = rs.getString(2);
				Double sal = rs.getDouble(3);
				String addr = rs.getString(4);
				
				return new Employee(eid, name, sal, addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	public List<Employee> readALL(){
		Connection connection = null;
		
		List<Employee> all = new ArrayList<>();
		try {
			connection =  DBUtil.getConnection();
			String sqlSelectQuery = "SELECT * FROM employee";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlSelectQuery);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int eid = rs.getInt(1);
				String name = rs.getString(2);
				Double sal = rs.getDouble(3);
				String addr = rs.getString(4);
				
				all.add(new Employee(eid, name, sal, addr));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return all;
	}
	
	public int update(Employee e){
		Connection connection = null;
		
		try { 
			connection =  DBUtil.getConnection();
			String sqlUpdateQuery =
				    "UPDATE employee SET ename = ?, esal = ?, eaddr = ? WHERE eid = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlUpdateQuery);
			
			pstmt.setString(1, e.getEname());
			pstmt.setDouble(2, e.getEsal());
			pstmt.setString(3, e.getEaddr());
			pstmt.setInt(4, e.getEid());
			
			int status = pstmt.executeUpdate();
			
			return status;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			
		return 0;
	}
	
	public int delete(int id) {
		Connection connection = null;
		
		try {
			connection =  DBUtil.getConnection();
			String sqlDeleteQuery = "DELETE FROM employee WHERE eid = ?;";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlDeleteQuery);
			
			pstmt.setInt(1, id);
			
			int status = pstmt.executeUpdate();
			
			return status;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			
		return 0;
	}
}
