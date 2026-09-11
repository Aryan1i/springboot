package com.aryan.jdbc.SQLInjection;


import java.util.*;
import java.sql.*;
import java.io.*;
public class SQLInjectionUsingPreparedStatementDemo {

	public static void main(String[] args) {
		InputStream is = SQLInjectionUsingPreparedStatementDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String sqlSelectQuery = "SELECT COUNT(*) FROM userinfo WHERE username = ? AND password = ?";
		
		try(Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sqlSelectQuery);
				Scanner scanner = new Scanner(System.in)){
			
			System.out.print("Enter the userName : ");
			String userName = scanner.nextLine();
			
			System.out.print("Enter the password :: ");
			String pwd = scanner.nextLine();
			
			System.out.println(sqlSelectQuery);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, pwd);
			
			ResultSet resultset = pstmt.executeQuery();
			
			int count = 0;
			
			if (resultset.next()) {
				count = resultset.getInt(1);
			}

			if (count == 0) {
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


/* OUTPUT

Enter the userName : sachin'-- 
Enter the password :: ayush
SELECT COUNT(*) FROM userinfo WHERE username = ? AND password = ?
INVALID CREDENTIALS...

*/