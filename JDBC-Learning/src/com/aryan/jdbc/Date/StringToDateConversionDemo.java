package com.aryan.jdbc.Date;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class StringToDateConversionDemo {

	public static void main(String[] args) throws ParseException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the date in following format [DD-MM-YYYY}");
		String stringDate = scanner.next();
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date utilDate = sdf.parse(stringDate);
		
		long input = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(input);
		System.out.println(sqlDate);
		
		String specialInput = "2026-08-11";
		java.sql.Date specialOutput = java.sql.Date.valueOf(specialInput);
		System.out.println(specialOutput);
		
		scanner.close();
	}

}
