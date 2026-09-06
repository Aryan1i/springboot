package com.aryan.jdbc.Clob;

import java.util.*;
import java.sql.*;
import java.io.*;

public class ClobTextFetchDemo {

	public static void main(String[] args) {
		InputStream is = ClobTextFetchDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		String query = "SELECT name, resume FROM jobSeeker WHERE jid = ?";

		try (
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(query);
			Scanner scanner = new Scanner(System.in);
		) {

			System.out.println("Enter the jid:");
			String jid = scanner.next();

			pstmt.setString(1, jid);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				String name = rs.getString("name");

				Reader reader = rs.getCharacterStream("resume");

				FileWriter fw = new FileWriter("src/FetchedLobs/FetchedTextUsingBuffer.txt");

                char[] buffer = new char[1024];

                int charsRead;

                while ((charsRead = reader.read(buffer)) != -1) {
                    fw.write(buffer, 0, charsRead);
                }

                reader.close();
                fw.close();

				System.out.println(name + " Text fetched successfully.");

			} else {
				System.out.println("No record found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
