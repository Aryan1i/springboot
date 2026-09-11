package com.aryan.jdbc.Blob;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class BlobImageInsertDemo {

	public static void main(String[] args) {
		InputStream is = BlobImageInsertDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String query = "INSERT INTO student (sname, image) VALUES (?, ?)";
		try(Connection con = DriverManager.getConnection(url, username , password);
				PreparedStatement pstmt = con.prepareStatement(query);
				Scanner scanner = new Scanner(System.in);) {
			
			
			System.out.println("Enter name of student");
			String name = scanner.next();
			
			InputStream imageStream = BlobImageInsertDemo.class.getClassLoader().getResourceAsStream("Resources/sachin-image.webp");
		
			pstmt.setString(1, name);
			pstmt.setBinaryStream(2,imageStream);
			
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

Enter name of student
Sachin
No of rows affected is : 1


*/