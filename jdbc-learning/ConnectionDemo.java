package com.aryan.jdbc.basics;

import java.sql.*;

public class ConnectionDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/jdbc_learning";
		String username = "admin";
		String password = "secretpassword";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfuly");
		} catch (SQLException e){
			System.out.println("Some Error Occured");
		}
	}
}


// Output

Connection Established Successfuly
