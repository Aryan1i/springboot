package com.aryan.jdbc.PreparedStatement;


import java.sql.*;
import java.util.*;
import java.io.*;
public class PreparedStatementExecuteMethodDemo {

	public static void main(String[] args) {
		InputStream is = PreparedStatementExecuteMethodDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the query ");
		String query = scanner.nextLine();
		
		try(Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(query);){
			
			boolean flag = pstmt.execute();
			
			if(flag) {
				ResultSet resultset = pstmt.getResultSet();
				while(resultset.next()) {
					int id = resultset.getInt(1);
					String name = resultset.getString("ename");
					double salary = resultset.getDouble(3);
					String address = resultset.getString(4);
					
					System.out.println(id + "\t" + name + "\t" + salary + "\t" + address);
				}
			} else {
				int noOfRowAffected = pstmt.getUpdateCount();
				
				if(noOfRowAffected == 0) {
					System.out.println("No rows affected in database");
				} else {
					System.out.println("No of rows affected is : " + noOfRowAffected);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


/* OUTPUT

Enter the query 
SELECT * FROM employee
7	dhoni	356000.0	CSK
9	lara	456789.0	Barbodas
10	sachin	456000.0	MI
18	kohli	426000.0	RCB
45	rohit	386000.0	GT

*/