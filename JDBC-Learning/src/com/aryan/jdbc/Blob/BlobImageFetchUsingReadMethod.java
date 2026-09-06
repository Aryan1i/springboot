package com.aryan.jdbc.Blob;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class BlobImageFetchUsingReadMethod {

	public static void main(String[] args) {
		InputStream is = BlobImageFetchUsingReadMethod.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String query = "SELECT * FROM student WHERE sid = ?";
		try(Connection con = DriverManager.getConnection(url, username , password);
				PreparedStatement pstmt = con.prepareStatement(query);
				Scanner scanner = new Scanner(System.in);) {
			
			System.out.println("Enter the sid of Student");
			int sid = scanner.nextInt();
			
			pstmt.setInt(1, sid);
			ResultSet resultset = pstmt.executeQuery();
			
			if(resultset.next()) {
				String name = resultset.getString(2);
				InputStream imageStream = resultset.getBinaryStream(3);
				
				FileOutputStream fos = new FileOutputStream("src/FetchedLobs/FetchedImageUsingReadMethod.webp");
				
				int i;
				while( (i = imageStream.read()) != -1) {
					fos.write(i);
				}
				
				System.out.println(name + " Image Fetched Succesfully");
				fos.close();
				imageStream.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/* 
Enter the sid of Student
1
Sachin Image Fetched Succesfully

*/

