package com.aryan.jdbc.utility;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {
	
	private DBUtil() {
		
	}
	
	private static Connection connection = null;
	
	static {
		HikariConfig config = new HikariConfig("db.properties");
        HikariDataSource datasource = new HikariDataSource(config);
        try {
			connection = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
        return connection; 
	}
}
