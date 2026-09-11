package com.aryan.jdbc.utility;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {
	
	private DBUtil() {
		
	}
	
	public static Connection connection = null;
	

	public static Connection getConnection() throws SQLException {
		HikariConfig config = new HikariConfig("db.properties");
        HikariDataSource datasource = new HikariDataSource(config);

        if (connection == null) {
            connection = datasource.getConnection();
        }

        return connection;
	}
}
