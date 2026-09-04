package com.aryan.jdbc.basics;

import java.sql.*;
import java.util.*;

public class TryWithResources {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/springboot";
		String username = "admin";
		String password = "secretpassword";
		
		try(Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
				Scanner scan = new Scanner(System.in);) {
			
			System.out.println("Enter the employee id which you want to delete");
			int deleteID = scan.nextInt();
			
			String query = String.format("DELETE FROM employee WHERE eid = %d", deleteID);
			
			int noOfRowAffected = stmt.executeUpdate(query);
			
			System.out.println("No of row Affected :- " + noOfRowAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
