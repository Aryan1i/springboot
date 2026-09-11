package com.aryan.jdbc.Clob;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.aryan.jdbc.Blob.BlobImageInsertDemo;

public class ClobTextInsertDemo {

	public static void main(String[] args) {
		InputStream is = ClobTextInsertDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String query = "INSERT INTO jobSeeker (name, resume) VALUES (?, ?)";
		try(Connection con = DriverManager.getConnection(url, username , password);
				PreparedStatement pstmt = con.prepareStatement(query);
				Scanner scanner = new Scanner(System.in);) {
			
			
			System.out.println("Enter the name");
			String name = scanner.next();
			
			InputStream textStream = ClobTextInsertDemo.class.getClassLoader().getResourceAsStream("Resources/resume.txt");
			
			Reader reader = new InputStreamReader(textStream);
			pstmt.setString(1, name);
			pstmt.setCharacterStream(2, reader);
			
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
