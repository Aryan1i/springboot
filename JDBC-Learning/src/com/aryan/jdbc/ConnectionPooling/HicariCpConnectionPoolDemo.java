package com.aryan.jdbc.ConnectionPooling;

import java.io.*;
import java.util.*;
import java.sql.*;

import com.zaxxer.hikari.*;
public class HicariCpConnectionPoolDemo {

	public static void main(String[] args) throws SQLException, IOException {
		InputStream is = HicariCpConnectionPoolDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setMaximumPoolSize(50);
		
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection connection = datasource.getConnection();
		
		System.out.println("Got connection object From connection pool");
		
		//closing the connection object
		connection.close();
		System.out.println("Sending back Connection object to Connection Pool");
		
	}

}


/* OUTPUT

// Before Adding slf4j jar and logback jar

Exception in thread "main" java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory
	at com.zaxxer.hikari.HikariConfig.<clinit>(HikariConfig.java:47)
	at com.aryan.jdbc.ConnectionPooling.HicariCpConnectionPoolDemo.main(HicariCpConnectionPoolDemo.java:29)
Caused by: java.lang.ClassNotFoundException: org.slf4j.LoggerFactory
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
	... 2 more

// After Adding slf4j jar and logback jar

22:01:05.926 [main] DEBUG com.zaxxer.hikari.HikariConfig -- HikariPool-1 - configuration:
22:01:05.939 [main] DEBUG com.zaxxer.hikari.HikariConfig -- allowPoolSuspension.............false
22:01:05.939 [main] DEBUG com.zaxxer.hikari.HikariConfig -- autoCommit......................true
22:01:05.940 [main] DEBUG com.zaxxer.hikari.HikariConfig -- catalog.........................none
22:01:05.940 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionInitSql...............none
22:01:05.940 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionTestQuery.............none
22:01:05.941 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionTimeout...............30000
22:01:05.941 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentials.....................com.zaxxer.hikari.util.Credentials@f5f2bb7
22:01:05.941 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentialsProvider.............none
22:01:05.941 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentialsProviderClassName....none
22:01:05.942 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSource......................none
22:01:05.942 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceClassName.............none
22:01:05.942 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceJNDI..................none
22:01:05.943 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceProperties............{password=<masked>}
22:01:05.943 [main] DEBUG com.zaxxer.hikari.HikariConfig -- driverClassName.................none
22:01:05.943 [main] DEBUG com.zaxxer.hikari.HikariConfig -- exceptionOverride...............none
22:01:05.943 [main] DEBUG com.zaxxer.hikari.HikariConfig -- exceptionOverrideClassName......none
22:01:05.943 [main] DEBUG com.zaxxer.hikari.HikariConfig -- healthCheckProperties...........{}
22:01:05.943 [main] DEBUG com.zaxxer.hikari.HikariConfig -- healthCheckRegistry.............none
22:01:05.944 [main] DEBUG com.zaxxer.hikari.HikariConfig -- idleTimeout.....................600000
22:01:05.944 [main] DEBUG com.zaxxer.hikari.HikariConfig -- initializationFailTimeout.......1
22:01:05.944 [main] DEBUG com.zaxxer.hikari.HikariConfig -- isolateInternalQueries..........false
22:01:05.944 [main] DEBUG com.zaxxer.hikari.HikariConfig -- jdbcUrl.........................jdbc:mysql://localhost:3307/springboot
22:01:05.944 [main] DEBUG com.zaxxer.hikari.HikariConfig -- keepaliveTime...................120000
22:01:05.944 [main] DEBUG com.zaxxer.hikari.HikariConfig -- leakDetectionThreshold..........0
22:01:05.945 [main] DEBUG com.zaxxer.hikari.HikariConfig -- maxLifetime.....................1800000
22:01:05.945 [main] DEBUG com.zaxxer.hikari.HikariConfig -- maximumPoolSize.................50
22:01:05.945 [main] DEBUG com.zaxxer.hikari.HikariConfig -- metricRegistry..................none
22:01:05.945 [main] DEBUG com.zaxxer.hikari.HikariConfig -- metricsTrackerFactory...........none
22:01:05.945 [main] DEBUG com.zaxxer.hikari.HikariConfig -- minimumIdle.....................50
22:01:05.945 [main] DEBUG com.zaxxer.hikari.HikariConfig -- password........................<masked>
22:01:05.946 [main] DEBUG com.zaxxer.hikari.HikariConfig -- poolName........................"HikariPool-1"
22:01:05.946 [main] DEBUG com.zaxxer.hikari.HikariConfig -- readOnly........................false
22:01:05.946 [main] DEBUG com.zaxxer.hikari.HikariConfig -- registerMbeans..................false
22:01:05.946 [main] DEBUG com.zaxxer.hikari.HikariConfig -- scheduledExecutor...............none
22:01:05.946 [main] DEBUG com.zaxxer.hikari.HikariConfig -- schema..........................none
22:01:05.946 [main] DEBUG com.zaxxer.hikari.HikariConfig -- threadFactory...................internal
22:01:05.947 [main] DEBUG com.zaxxer.hikari.HikariConfig -- transactionIsolation............default
22:01:05.947 [main] DEBUG com.zaxxer.hikari.HikariConfig -- username........................"admin"
22:01:05.947 [main] DEBUG com.zaxxer.hikari.HikariConfig -- validationTimeout...............5000
22:01:05.957 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Starting...
22:01:05.977 [main] DEBUG com.zaxxer.hikari.util.DriverDataSource -- Loaded driver with class name com.mysql.cj.jdbc.Driver for jdbcUrl=jdbc:mysql://localhost:3307/springboot
22:01:06.005 [main] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Attempting to create/setup new connection (fa1be884-c75d-435d-8115-289d1ab7ce74)
22:01:06.368 [main] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Established new connection (fa1be884-c75d-435d-8115-289d1ab7ce74)
22:01:06.369 [main] INFO com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@17f9d882
22:01:06.370 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Start completed.
Got connection object From connection pool
Sending back Connection object to Connection Pool
*/


