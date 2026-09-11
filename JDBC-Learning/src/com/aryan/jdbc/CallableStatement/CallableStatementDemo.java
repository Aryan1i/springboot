package com.aryan.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class CallableStatementDemo {

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig("db.properties");
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection con = datasource.getConnection();
		System.out.println("Connection from HIkariCp Pool : "+ con);
		
		//write a logic to make a call to StoredProcedure : getEmployeeNameById(IN,OUT)
		String storeProcedureName = "{CALL getEmployeeNameById(?, ?)}";
		CallableStatement cstmt = con.prepareCall(storeProcedureName);
		
		int id = 10;
		cstmt.setInt(1, id);
		
		//registering the output variable to collect the output [ Database [datatype] ---> java [Datatype] ] 
		cstmt.registerOutParameter(2, Types.VARCHAR);
		
		cstmt.execute();
		
		String empName = cstmt.getString(2);
		
		if (empName!=null) {
			System.out.println("Record found and the name is : " + empName);
		} else {
			System.out.println("Record not found for the id : " + id);
		}
		
		con.close();
		System.out.println("Sending connection back to hikariCP pool");
		
		datasource.close();
		System.out.println("Shutting down the connection pool of HIkariCP");
		
	}

}


//OUTPUT

/*
 * 02:23:41.848 [main] DEBUG com.zaxxer.hikari.HikariConfig -- HikariPool-1 - configuration:
02:23:41.857 [main] DEBUG com.zaxxer.hikari.HikariConfig -- allowPoolSuspension.............false
02:23:41.857 [main] DEBUG com.zaxxer.hikari.HikariConfig -- autoCommit......................true
02:23:41.857 [main] DEBUG com.zaxxer.hikari.HikariConfig -- catalog.........................none
02:23:41.857 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionInitSql...............none
02:23:41.858 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionTestQuery.............none
02:23:41.859 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionTimeout...............30000
02:23:41.859 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentials.....................com.zaxxer.hikari.util.Credentials@2eee9593
02:23:41.859 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentialsProvider.............none
02:23:41.859 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentialsProviderClassName....none
02:23:41.859 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSource......................none
02:23:41.859 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceClassName.............none
02:23:41.860 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceJNDI..................none
02:23:41.860 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceProperties............{password=<masked>}
02:23:41.860 [main] DEBUG com.zaxxer.hikari.HikariConfig -- driverClassName.................none
02:23:41.860 [main] DEBUG com.zaxxer.hikari.HikariConfig -- exceptionOverride...............none
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- exceptionOverrideClassName......none
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- healthCheckProperties...........{}
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- healthCheckRegistry.............none
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- idleTimeout.....................600000
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- initializationFailTimeout.......1
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- isolateInternalQueries..........false
02:23:41.861 [main] DEBUG com.zaxxer.hikari.HikariConfig -- jdbcUrl.........................jdbc:mysql://localhost:3307/springboot
02:23:41.862 [main] DEBUG com.zaxxer.hikari.HikariConfig -- keepaliveTime...................120000
02:23:41.862 [main] DEBUG com.zaxxer.hikari.HikariConfig -- leakDetectionThreshold..........0
02:23:41.862 [main] DEBUG com.zaxxer.hikari.HikariConfig -- maxLifetime.....................1800000
02:23:41.862 [main] DEBUG com.zaxxer.hikari.HikariConfig -- maximumPoolSize.................50
02:23:41.862 [main] DEBUG com.zaxxer.hikari.HikariConfig -- metricRegistry..................none
02:23:41.863 [main] DEBUG com.zaxxer.hikari.HikariConfig -- metricsTrackerFactory...........none
02:23:41.863 [main] DEBUG com.zaxxer.hikari.HikariConfig -- minimumIdle.....................50
02:23:41.863 [main] DEBUG com.zaxxer.hikari.HikariConfig -- password........................<masked>
02:23:41.863 [main] DEBUG com.zaxxer.hikari.HikariConfig -- poolName........................"HikariPool-1"
02:23:41.863 [main] DEBUG com.zaxxer.hikari.HikariConfig -- readOnly........................false
02:23:41.863 [main] DEBUG com.zaxxer.hikari.HikariConfig -- registerMbeans..................false
02:23:41.864 [main] DEBUG com.zaxxer.hikari.HikariConfig -- scheduledExecutor...............none
02:23:41.864 [main] DEBUG com.zaxxer.hikari.HikariConfig -- schema..........................none
02:23:41.864 [main] DEBUG com.zaxxer.hikari.HikariConfig -- threadFactory...................internal
02:23:41.864 [main] DEBUG com.zaxxer.hikari.HikariConfig -- transactionIsolation............default
02:23:41.864 [main] DEBUG com.zaxxer.hikari.HikariConfig -- username........................"admin"
02:23:41.864 [main] DEBUG com.zaxxer.hikari.HikariConfig -- validationTimeout...............5000
02:23:41.872 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Starting...
02:23:41.890 [main] DEBUG com.zaxxer.hikari.util.DriverDataSource -- Loaded driver with class name com.mysql.cj.jdbc.Driver for jdbcUrl=jdbc:mysql://localhost:3307/springboot
02:23:41.914 [main] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Attempting to create/setup new connection (c335cafa-91f0-495f-b58a-fa440cf43204)
02:23:42.251 [main] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Established new connection (c335cafa-91f0-495f-b58a-fa440cf43204)
02:23:42.252 [main] INFO com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@5afa3c9
02:23:42.253 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Start completed.
Connection from HIkariCp Pool : HikariProxyConnection@1529115495 wrapping com.mysql.cj.jdbc.ConnectionImpl@5afa3c9
Record found and the name is : sachin
Sending connection back to hikariCP pool
02:23:42.346 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Shutdown initiated...
02:23:42.346 [main] DEBUG com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - Before shutdown stats (total=1/50, idle=1/50, active=0, waiting=0)
02:23:42.347 [HikariPool-1:connection-closer] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Closing connection com.mysql.cj.jdbc.ConnectionImpl@5afa3c9: (connection evicted)
02:23:42.348 [main] DEBUG com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - After  shutdown stats (total=0/50, idle=0/50, active=0, waiting=0)
02:23:42.349 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Shutdown completed.
Shutting down the connection pool of HIkariCP
*/
