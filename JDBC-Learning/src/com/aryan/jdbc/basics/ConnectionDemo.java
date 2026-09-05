package com.aryan.jdbc.basics;

import java.sql.*;

public class ConnectionDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/springboot";
		String username = "admin";
		String password = "secretpassword";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfuly " + con);
		} catch (SQLException e){
			System.out.println("Some Error Occured");
		}
	}
}


/* OUTPUT

Connection Established Successfuly com.mysql.cj.jdbc.ConnectionImpl@445b295b

*/