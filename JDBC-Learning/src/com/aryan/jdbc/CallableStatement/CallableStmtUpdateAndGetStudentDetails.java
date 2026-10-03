package com.aryan.jdbc.CallableStatement;

import java.sql.*;
import com.zaxxer.hikari.*;
public class CallableStmtUpdateAndGetStudentDetails {

	public static void main(String[] args) {
		HikariConfig config = new HikariConfig("db.properties");
		
		String storeProcedureName = "{CALL UpdateAndGetStudentDetails(?, ?)}";
		
		try(HikariDataSource datasource = new HikariDataSource(config);
				Connection con = datasource.getConnection();
				CallableStatement cstmt = con.prepareCall(storeProcedureName);){
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 5);
			
			boolean status = cstmt.execute();
			
			while(true) {
				if(status) {
					ResultSet resultset = cstmt.getResultSet();
					while(resultset.next()) {
						int id = resultset.getInt(1);
						String name = resultset.getString("name");
						int mark = resultset.getInt(3);
						
						System.out.println(id + "\t" + name + "\t" + mark);
					}
				} else {
					int noOfRowAffected = cstmt.getUpdateCount();
					
					if(noOfRowAffected == -1) {
						break;
					}else {
						System.out.println("No of rows affected is : " + noOfRowAffected);
					}
					
				}
				
				status = cstmt.getMoreResults();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


/* OUTPUT

 1	Sachin	91
2	Virat	98
3	Rohit	81
4	Dhoni	100
3	Rohit	86
No of rows affected is : 0

*/
