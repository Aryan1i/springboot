package com.aryan.jdbc.ConnectionPooling;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpConnectionPoolHikariDbDemo {

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig("HikariDb.properties");
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection connection = datasource.getConnection();
		System.out.println("Got connection object From connection pool :- " + connection);
		
		//closing the connection object
		connection.close();
		System.out.println("Sending back Connection object to Connection Pool");
		
		datasource.close();
		System.out.println("Shuting Down the DataSource");
	}

}


/* OUTPUT
23:56:27.174 [main] DEBUG com.zaxxer.hikari.HikariConfig -- HikariPool-1 - configuration:
23:56:27.184 [main] DEBUG com.zaxxer.hikari.HikariConfig -- allowPoolSuspension.............false
23:56:27.184 [main] DEBUG com.zaxxer.hikari.HikariConfig -- autoCommit......................true
23:56:27.184 [main] DEBUG com.zaxxer.hikari.HikariConfig -- catalog.........................none
23:56:27.184 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionInitSql...............none
23:56:27.185 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionTestQuery.............none
23:56:27.186 [main] DEBUG com.zaxxer.hikari.HikariConfig -- connectionTimeout...............30000
23:56:27.186 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentials.....................com.zaxxer.hikari.util.Credentials@2eee9593
23:56:27.186 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentialsProvider.............none
23:56:27.186 [main] DEBUG com.zaxxer.hikari.HikariConfig -- credentialsProviderClassName....none
23:56:27.187 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSource......................none
23:56:27.187 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceClassName.............none
23:56:27.187 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceJNDI..................none
23:56:27.187 [main] DEBUG com.zaxxer.hikari.HikariConfig -- dataSourceProperties............{password=<masked>}
23:56:27.188 [main] DEBUG com.zaxxer.hikari.HikariConfig -- driverClassName.................none
23:56:27.188 [main] DEBUG com.zaxxer.hikari.HikariConfig -- exceptionOverride...............none
23:56:27.188 [main] DEBUG com.zaxxer.hikari.HikariConfig -- exceptionOverrideClassName......none
23:56:27.188 [main] DEBUG com.zaxxer.hikari.HikariConfig -- healthCheckProperties...........{}
23:56:27.188 [main] DEBUG com.zaxxer.hikari.HikariConfig -- healthCheckRegistry.............none
23:56:27.188 [main] DEBUG com.zaxxer.hikari.HikariConfig -- idleTimeout.....................600000
23:56:27.189 [main] DEBUG com.zaxxer.hikari.HikariConfig -- initializationFailTimeout.......1
23:56:27.189 [main] DEBUG com.zaxxer.hikari.HikariConfig -- isolateInternalQueries..........false
23:56:27.189 [main] DEBUG com.zaxxer.hikari.HikariConfig -- jdbcUrl.........................jdbc:mysql://localhost:3307/springboot
23:56:27.189 [main] DEBUG com.zaxxer.hikari.HikariConfig -- keepaliveTime...................120000
23:56:27.189 [main] DEBUG com.zaxxer.hikari.HikariConfig -- leakDetectionThreshold..........0
23:56:27.189 [main] DEBUG com.zaxxer.hikari.HikariConfig -- maxLifetime.....................1800000
23:56:27.190 [main] DEBUG com.zaxxer.hikari.HikariConfig -- maximumPoolSize.................50
23:56:27.190 [main] DEBUG com.zaxxer.hikari.HikariConfig -- metricRegistry..................none
23:56:27.190 [main] DEBUG com.zaxxer.hikari.HikariConfig -- metricsTrackerFactory...........none
23:56:27.190 [main] DEBUG com.zaxxer.hikari.HikariConfig -- minimumIdle.....................50
23:56:27.191 [main] DEBUG com.zaxxer.hikari.HikariConfig -- password........................<masked>
23:56:27.191 [main] DEBUG com.zaxxer.hikari.HikariConfig -- poolName........................"HikariPool-1"
23:56:27.191 [main] DEBUG com.zaxxer.hikari.HikariConfig -- readOnly........................false
23:56:27.191 [main] DEBUG com.zaxxer.hikari.HikariConfig -- registerMbeans..................false
23:56:27.191 [main] DEBUG com.zaxxer.hikari.HikariConfig -- scheduledExecutor...............none
23:56:27.192 [main] DEBUG com.zaxxer.hikari.HikariConfig -- schema..........................none
23:56:27.192 [main] DEBUG com.zaxxer.hikari.HikariConfig -- threadFactory...................internal
23:56:27.192 [main] DEBUG com.zaxxer.hikari.HikariConfig -- transactionIsolation............default
23:56:27.192 [main] DEBUG com.zaxxer.hikari.HikariConfig -- username........................"admin"
23:56:27.192 [main] DEBUG com.zaxxer.hikari.HikariConfig -- validationTimeout...............5000
23:56:27.200 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Starting...
23:56:27.221 [main] DEBUG com.zaxxer.hikari.util.DriverDataSource -- Loaded driver with class name com.mysql.cj.jdbc.Driver for jdbcUrl=jdbc:mysql://localhost:3307/springboot
23:56:27.249 [main] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Attempting to create/setup new connection (db98e34c-48b8-4c6c-99aa-317ed3b5a2cf)
23:56:27.730 [main] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Established new connection (db98e34c-48b8-4c6c-99aa-317ed3b5a2cf)
23:56:27.732 [main] INFO com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@5afa3c9
23:56:27.733 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Start completed.
Got connection object From connection pool :- HikariProxyConnection@1529115495 wrapping com.mysql.cj.jdbc.ConnectionImpl@5afa3c9
Sending back Connection object to Connection Pool
23:56:27.755 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Shutdown initiated...
23:56:27.755 [main] DEBUG com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - Before shutdown stats (total=1/50, idle=1/50, active=0, waiting=0)
23:56:27.756 [HikariPool-1:connection-closer] DEBUG com.zaxxer.hikari.pool.PoolBase -- HikariPool-1 - Closing connection com.mysql.cj.jdbc.ConnectionImpl@5afa3c9: (connection evicted)
23:56:27.761 [main] DEBUG com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - After  shutdown stats (total=0/50, idle=0/50, active=0, waiting=0)
23:56:27.761 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Shutdown completed.
Shuting Down the DataSource
*/