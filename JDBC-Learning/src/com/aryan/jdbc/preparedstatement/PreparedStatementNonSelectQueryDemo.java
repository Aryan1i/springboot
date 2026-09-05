package com.aryan.jdbc.preparedstatement;

import java.sql.*;
import java.util.*;
import java.io.*;

public class PreparedStatementNonSelectQueryDemo {

	public static void main(String[] args) {
		InputStream is = PreparedStatementNonSelectQueryDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String nonSelectQuery = "INSERT INTO employee VALUES (? , ? , ? , ?)";
		
		try(Connection con = DriverManager.getConnection(url , username, password);
				PreparedStatement pstmt = con.prepareStatement(nonSelectQuery);
				Scanner scanner = new Scanner(System.in);){
			
			System.out.println("Enter the id of an Employee");
			int id = scanner.nextInt();

			System.out.println("Enter the Name of an Employee :: ");
			String name = scanner.next();

			System.out.println("Enter the Salary of an Employee :: ");
			double salary = scanner.nextDouble();

			System.out.println("Enter the Address of an Employee :: ");
			String address = scanner.next();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, salary);
			pstmt.setString(4, address);
			
			int noOfRowAffected = pstmt.executeUpdate();
			
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


/* OUTPUT

Enter the id of an Employee
9
Enter the Name of an Employee :: 
lara
Enter the Salary of an Employee :: 
456789.05
Enter the Address of an Employee :: 
Barbodas
No of rows affected is : 1

*/