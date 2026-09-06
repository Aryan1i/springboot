package com.aryan.jdbc.Date;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
public class DateInsertDemo {

	public static void main(String[] args) throws ParseException {
		InputStream is = DateInsertDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String query = "INSERT INTO customer VALUES (? ,? ,?, ?, ?)";
		try(Connection con = DriverManager.getConnection(url, username , password);
				PreparedStatement pstmt = con.prepareStatement(query);
				Scanner scanner = new Scanner(System.in);) {
			
			System.out.println("Enter ID of costomer");
			int id = scanner.nextInt();
			
			System.out.println("Enter name of costomer");
			String name = scanner.next();
			
			System.out.println("Enter cdob in dd-MM-yyyy");
			String cdob = scanner.next();
			
			System.out.println("Enter cdoj in MM-dd-yyyy");
			String cdoj = scanner.next();
			
			System.out.println("Enter cdom in yyyy-MM-dd");
			String cdom = scanner.next();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date utilCdob = sdf.parse(cdob);
			java.sql.Date sqlCdob = new java.sql.Date(utilCdob.getTime());
			System.out.println("SQL costumer dob :- " + sqlCdob);
			
			sdf = new SimpleDateFormat("MM-dd-yyyy");
			Date utilCdoj = sdf.parse(cdoj);
			java.sql.Date sqlCdoj = new java.sql.Date(utilCdoj.getTime());
			System.out.println("SQL costumer doj :- " + sqlCdoj);
			
			java.sql.Date sqlCdom = java.sql.Date.valueOf(cdom);
			System.out.println("SQL costumer dom :- " + sqlCdom);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDate(3, sqlCdob);
			pstmt.setDate(4, sqlCdoj);
			pstmt.setDate(5, sqlCdom);
			
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
 * 
Enter ID of costomer
1
Enter name of costomer
sachin
Enter cdob in dd-MM-yyyy
11-08-2026
Enter cdoj in MM-dd-yyyy
08-11-2026
Enter cdom in yyyy-MM-dd
2026-08-11
SQL costumer dob :- 2026-08-11
SQL costumer doj :- 2026-08-11
SQL costumer dom :- 2026-08-11
No of rows affected is : 1

*/
