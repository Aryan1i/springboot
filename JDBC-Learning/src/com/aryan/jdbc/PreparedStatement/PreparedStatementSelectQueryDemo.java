package com.aryan.jdbc.PreparedStatement;

import java.sql.*;
import java.io.*;
import java.util.*;


public class PreparedStatementSelectQueryDemo {

	public static void main(String[] args) {
		InputStream is = PreparedStatementSelectQueryDemo.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			properties.load(is);
			
			url = properties.getProperty("jdbcUrl");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String selectQuery = "SELECT * FROM employee WHERE eid = ?";
		try(Connection con = DriverManager.getConnection(url, username , password);
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				Scanner scanner = new Scanner(System.in);) {
			
			System.out.println("Enter the id of an Employee");
			int eid = scanner.nextInt();
			
			pstmt.setInt(1, eid);
			
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString("ename");
				double salary = resultset.getDouble(3);
				String address = resultset.getString(4);
				
				System.out.println(id + "\t" + name + "\t" + salary + "\t" + address);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
	}

}


/* OUTPUT

Enter the id of an Employee
10
10	sachin	456000.0	MI


*/