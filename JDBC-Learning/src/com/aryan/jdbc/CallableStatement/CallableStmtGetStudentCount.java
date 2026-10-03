package com.aryan.jdbc.CallableStatement;

import com.zaxxer.hikari.*;
import java.sql.*;

public class CallableStmtGetStudentCount {

	public static void main(String[] args) {
		HikariConfig config = new HikariConfig("db.properties");
		
		String storeProcedureName = "{CALL GetStudentCount(?)}";
		
		try(HikariDataSource datasource = new HikariDataSource(config);
				Connection con = datasource.getConnection();
				CallableStatement cstmt = con.prepareCall(storeProcedureName);){
			
			cstmt.registerOutParameter(1, Types.INTEGER);
			
			cstmt.execute();
			
			int count = cstmt.getInt(1);
			
			System.out.println("Count of Student is :- " + count);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}


//OUTPUT

// Count of Student is :- 4