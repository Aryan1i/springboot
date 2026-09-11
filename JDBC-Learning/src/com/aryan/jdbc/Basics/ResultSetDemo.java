package com.aryan.jdbc.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3308/springboot";
		String username = "admin";
		String password = "secretpassword";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established :: " + con);
			
			stmt = con.createStatement();
			
			String sqlSelectQuery = "select * from employee";
			
			resultSet = stmt.executeQuery(sqlSelectQuery);
			
			while(resultSet.next()){
				int id = resultSet.getInt("eid");
				String name = resultSet.getString(2);
				Double salary = resultSet.getDouble(3);
				String address = resultSet.getString(4);
				
				System.out.println(id + "\t" + name + "\t" + salary + "\t" + address);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

/* OUTPUT

Connection established :: com.mysql.cj.jdbc.ConnectionImpl@445b295b
7	dhoni	356000.0	CSK
9	lara	456789.0	Barbodas
10	sachin	456000.0	MI
18	kohli	426000.0	RCB
45	rohit	386000.0	GT

*/