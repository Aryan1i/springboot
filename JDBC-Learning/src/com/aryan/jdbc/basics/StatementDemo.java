package com.aryan.jdbc.basics;

import java.sql.*;
import java.util.Scanner;

public class StatementDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/springboot";
		String username = "admin";
		String password = "secretpassword";
		
		Connection con = null;
		Statement stmt = null;
		Scanner scanner = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established :: " + con);
			
			stmt = con.createStatement();
			
			scanner = new Scanner(System.in);
			
			System.out.println("Enter the Id of an Employee :: ");
			int id = scanner.nextInt();

			System.out.println("Enter the Name of an Employee :: ");
			String name = scanner.next();

			System.out.println("Enter the Salary of an Employee :: ");
			double salary = scanner.nextDouble();

			System.out.println("Enter the Address of an Employee :: ");
			String address = scanner.next();

			String nonSelectQuery = String.format("insert into employee values(%d,'%s',%f,'%s')", 
							id, name, salary,address);

			// 3. Send and execute the query at DBside
			int noOfRowsAffected = stmt.executeUpdate(nonSelectQuery);
			
			if(noOfRowsAffected == 0) {
				System.out.println("No row Affected");
			} else {
				System.out.println("Number of row Affected :-" + noOfRowsAffected);
			}
			
		} catch(SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
				scanner.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

/* OUTPUT

Connection established :: com.mysql.cj.jdbc.ConnectionImpl@445b295b
Enter the Id of an Employee :: 
1
Enter the Name of an Employee :: 
TEST
Enter the Salary of an Employee :: 
100000
Enter the Address of an Employee :: 
MUMBAI
Number of row Affected :-1

*/
