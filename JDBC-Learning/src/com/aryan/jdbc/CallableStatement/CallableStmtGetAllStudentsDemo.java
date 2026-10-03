package com.aryan.jdbc.CallableStatement;

import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class CallableStmtGetAllStudentsDemo {

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig("db.properties");
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection con = datasource.getConnection();
		
		String storeProcedureName = "{CALL GetAllStudents()}";
		CallableStatement cstmt = con.prepareCall(storeProcedureName);
		
		boolean flag = cstmt.execute();
		
		if(flag) {
			ResultSet resultset = cstmt.getResultSet();
			while(resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				int mark = resultset.getInt(3);
				System.out.println("id :- " + id + " name :- " + name + "mark :- " + mark);
			}
		}
		
		cstmt.close();
		datasource.close();
	}

}

//OUTPUT

/*00:37:49.251 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Start completed.
id :- 1 name :- Sachinmark :- 91
id :- 2 name :- Viratmark :- 98
id :- 3 name :- Rohitmark :- 76
id :- 4 name :- Dhonimark :- 95
00:37:49.314 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Shutdown initiated...
00:37:49.314 [main] DEBUG com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - Before shutdown stats (total=1/50, idle=0/50, active=1, waiting=0)
00:37:49.318 [main] DEBUG com.zaxxer.hikari.pool.HikariPool -- HikariPool-1 - After  shutdown stats (total=0/50, idle=0/50, active=0, waiting=0)
00:37:49.318 [main] INFO com.zaxxer.hikari.HikariDataSource -- HikariPool-1 - Shutdown completed.

*/
