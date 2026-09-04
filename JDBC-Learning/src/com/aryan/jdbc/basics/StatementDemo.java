package com.aryan.jdbc.basics;

import java.sql.*;

public class StatementDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/jdbc_learning";
		String username = "admin";
		String password = "secretpassword";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established :: " + con);
			
			stmt = con.createStatement();
			
			String sqlSelectQuery = "select * from employee";
			
			resultSet = stmt.executeQuery(sqlSelectQuery);
			
			while(resultSet.next()){
				int id = resultSet.getInt("eid");
				String name = resultSet.getString(2);
				Double salary = resultSet.getDouble(3);
				String address = resultSet.getString(4);
				
				System.out.println(id + "\t" + name + "\t" + salary + "\t" + address);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
