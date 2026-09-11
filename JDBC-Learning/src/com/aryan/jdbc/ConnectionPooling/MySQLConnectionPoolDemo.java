package com.aryan.jdbc.ConnectionPooling;

import java.io.*;
import java.util.*;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.*;

public class MySQLConnectionPoolDemo {

	public static void main(String[] args) throws SQLException, IOException {
		InputStream is = MySQLConnectionPoolDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		//Creating a pool of Connection objects
		MysqlConnectionPoolDataSource datasource = new MysqlConnectionPoolDataSource();
		
		datasource.setUrl(url);
		datasource.setUser(username);
		datasource.setPassword(password);
		
		//Get the connection object from connection pool
		Connection connection = datasource.getConnection();
		System.out.println("Got connection object From connection pool");
		
		System.in.read(); // pause the execution till the time customer gives any input
		
		//closing the connection object
		connection.close();
		System.out.println("Sending back Connection object to Connection Pool");
	}

}


/* OUTPUT

Got connection object From connection pool

Sending back Connection object to Connection Pool

*/