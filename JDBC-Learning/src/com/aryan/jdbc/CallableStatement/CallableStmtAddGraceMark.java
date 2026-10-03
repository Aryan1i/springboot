package com.aryan.jdbc.CallableStatement;

import com.zaxxer.hikari.*;
import java.sql.*;

public class CallableStmtAddGraceMark {

	public static void main(String[] args) {
		HikariConfig config = new HikariConfig("db.properties");
		
		String storeProcedureName = "{CALL AddGraceMark(?, ?)}";
		
		try(HikariDataSource datasource = new HikariDataSource(config);
				Connection con = datasource.getConnection();
				CallableStatement cstmt = con.prepareCall(storeProcedureName);){
			
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 5);
			cstmt.registerOutParameter(2, Types.INTEGER);
			
			cstmt.execute();
			
			System.out.println("New Updated mark of student  is " + cstmt.getInt(2));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


//OUTPUT

// New Updated mark of student  is 81