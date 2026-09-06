package com.aryan.jdbc.BatchUpdate;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class BatchUpdateUsingStatementDemo {

	public static void main(String[] args) {
		InputStream is = BatchUpdateUsingStatementDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
				Scanner scanner = new Scanner(System.in);) {
			
			stmt.addBatch("INSERT INTO employee VALUES (25, 'bumrah', 400000, 'MI')");
			stmt.addBatch("INSERT INTO employee VALUES (30, 'pant', 390000, 'DC')");

			stmt.addBatch("UPDATE employee SET esal = 500000 WHERE eid = 10");
			stmt.addBatch("UPDATE employee SET eaddr = 'MI' WHERE eid = 45");

			stmt.addBatch("DELETE FROM employee WHERE eid = 25");
			
			
			int[] rowsAffected = stmt.executeBatch();
			
			int noOfRowAffected = 0;
			
			for(int data:rowsAffected){
				noOfRowAffected+=data;
			}
			
			if(noOfRowAffected == 0) {
				System.out.println("No rows affected in database");
			} else {
				System.out.println("No of rows affected is : " + noOfRowAffected);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// OUTPUT
// No of rows affected is : 5

