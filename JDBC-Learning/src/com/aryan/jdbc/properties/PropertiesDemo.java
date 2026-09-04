package com.aryan.jdbc.properties;

import java.io.InputStream;
import java.util.*;

public class PropertiesDemo {

	public static void main(String[] args) {
		InputStream is = PropertiesDemo.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		
		String url = null;
		String username = null;
		String password = null;
		
		try {
			properties.load(is);
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
			System.out.println("url :- " + url);
			System.out.println("username :- " + username);
			System.out.println("password :- " + password);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
