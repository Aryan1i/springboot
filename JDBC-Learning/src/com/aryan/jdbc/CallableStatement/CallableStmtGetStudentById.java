package com.aryan.jdbc.CallableStatement;

import com.zaxxer.hikari.*;
import java.sql.*;

public class CallableStmtGetStudentById {

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig("db.properties");
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection con = datasource.getConnection();
		
		String storeProcedureName = "{CALL GetStudentsById(?)}";
		CallableStatement cstmt = con.prepareCall(storeProcedureName);
		
		cstmt.setInt(1, 1);
		
		boolean flag = cstmt.execute();
		
		if(flag) {
			ResultSet resultset = cstmt.getResultSet();
			
			if(resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				int mark = resultset.getInt(3);
				System.out.println("id :- " + id + " name :- " + name + "mark :- " + mark);
			}
			
		}
		
		con.close();
		datasource.close();
		
	}

}


//OUTPUT

// id :- 1 name :- Sachinmark :- 91

