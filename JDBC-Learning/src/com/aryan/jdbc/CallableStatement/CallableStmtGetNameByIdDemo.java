package com.aryan.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class CallableStmtGetNameByIdDemo {

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig("db.properties");
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection con = datasource.getConnection();
		System.out.println("Connection from HIkariCp Pool : "+ con);
		
		//write a logic to make a call to StoredProcedure : getEmployeeNameById(IN,OUT)
		String storeProcedureName = "{CALL getStudentNameById(?, ?)}";
		CallableStatement cstmt = con.prepareCall(storeProcedureName);
		
		int id = 1;
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
