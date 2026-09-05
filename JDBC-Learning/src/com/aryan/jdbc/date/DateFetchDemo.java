package com.aryan.jdbc.date;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;

public class DateFetchDemo {

	public static void main(String[] args) {
		InputStream is = DateFetchDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String selectQuery = "SELECT * FROM customer";
		try(Connection con = DriverManager.getConnection(url, username , password);
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				Scanner scanner = new Scanner(System.in);) {
			
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				int cid = resultset.getInt(1);
				String cname = resultset.getString(2);
				java.sql.Date cdob = resultset.getDate(3);
				java.sql.Date cdoj = resultset.getDate(4);
				java.sql.Date cdom = resultset.getDate(5);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String scDob = sdf.format(cdob);
				String scDoj = sdf.format(cdoj);
				String scDom = sdf.format(cdom);
				
				System.out.println(cid + "\t" + cname + "\t" + scDob + "\t" + scDoj + "\t" + scDom);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
