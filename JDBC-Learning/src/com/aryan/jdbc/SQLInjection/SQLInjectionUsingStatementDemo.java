package com.aryan.jdbc.SQLInjection;

import java.util.*;
import java.sql.*;
import java.io.*;
public class SQLInjectionUsingStatementDemo {

	public static void main(String[] args) {
		InputStream is = SQLInjectionUsingStatementDemo.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			properties.load(is);
			
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(url, username , password);
				Statement stmt = con.createStatement();
				Scanner scanner = new Scanner(System.in);){
			
			System.out.print("Enter the userName : ");
			String userName = scanner.nextLine();
			
			System.out.print("Enter the password :: ");
			String pwd = scanner.nextLine();
			
			String sqlSelectQuery = String.format("SELECT count(*) FROM userinfo WHERE username = '%s' AND password = '%s'", userName, pwd);
			
			System.out.println(sqlSelectQuery);
			
			ResultSet resultset = stmt.executeQuery(sqlSelectQuery);
			
			int count = 0;
			
			if(resultset.next()) {
				count = resultset.getInt(1);
			}
			
			if(count == 0) {
				System.out.println("INVALID CREDENTIALS...");
			} else {
				System.out.println("VALID CREDENTIALS...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


// OUTPUT 

/*
Enter the userName : sachin'-- 
Enter the password :: ayush
SELECT count(*) FROM userinfo WHERE username = 'sachin'-- ' AND password = 'ayush'
VALID CREDENTIALS...

*/

