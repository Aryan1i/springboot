package com.aryan.jdbc.BatchUpdate;

import java.io.IOException;
import java.io.InputStream;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class BatchUpdateTransactionDemo {

	public static void main(String[] args) {
		InputStream is = BatchUpdateUsingStatementDemo.class.getClassLoader().getResourceAsStream("db.properties");
		
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
		
		
		try(Connection con = DriverManager.getConnection(url, username , password);
				Statement stmt = con.createStatement();
				Scanner scanner = new Scanner(System.in);) {
			

            con.setAutoCommit(false);
            
            System.out.println("Enter the amount to be transferred : ");
            int amount = scanner.nextInt();

            System.out.println("Enter the account no : ");
            int accNo = scanner.nextInt();

            try {
                stmt.addBatch(
                    "UPDATE ACCOUNT_1 SET balance = balance - "
                    + amount + " WHERE accNo = 1234"
                );

                stmt.addBatch(
                    "UPDATE ACCOUNT_2 SET balance = balance + "
                    + amount + " WHERE accNo = " + accNo
                );

                int[] rowsAffected = stmt.executeBatch();
                
                int noOfRowAffected = 0;
    			
    			for(int data : rowsAffected){
    				noOfRowAffected+=data;
    			}
    			
    			if(noOfRowAffected == 0) {
    				System.out.println("No rows affected in database");
    			} else {
    				System.out.println("No of rows affected is : " + noOfRowAffected);
    			}

                con.commit();

                System.out.println("Amount transferred successfully");

            } catch (BatchUpdateException e) {

                con.rollback();

                System.out.println("Amount transfer failed");
                e.printStackTrace();
            }
            
            String selectQuery = "SELECT * FROM ACCOUNT_2 WHERE accNo = " + accNo;

            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\n----- Account Details -----");

            if (rs.next()) {
                System.out.println("Account No   : " + rs.getInt("accNo"));
                System.out.println("Account Name : " + rs.getString("accName"));
                System.out.println("Balance      : " + rs.getInt("balance"));
            }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


/* OUTPUT


Enter the amount to be transferred : 
3000
Enter the account no : 
2341
No of rows affected is : 2
Amount transferred successfully

----- Account Details -----
Account No   : 2341
Account Name : gagan
Balance      : 11000

*/
