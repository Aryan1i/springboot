package com.aryan.jdbc;

import java.util.Scanner;

import com.aryan.jdbc.model.Employee;
import com.aryan.jdbc.service.EmployeeServiceImpl;
import com.aryan.jdbc.service.IEmployeeService;

public class MainController {

	public static void main(String[] args) {
		System.out.println("***********************************");
		System.out.println("SERVICES OFFERED BY JDBCAPP");
		System.out.println("***********************************");
		System.out.println("1. INSERT");
		System.out.println("2. SELECT ON ID");
		System.out.println("3. SELECT ALL");
		System.out.println("4. UPDATE");
		System.out.println("5. DELETE");
		System.out.println("6. EXIT");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("ENTER UR CHOICE  :: ");
		int choice = scanner.nextInt();
		
		scanner.nextLine();
		
		String name = "";
		String salary = "";
		String address = "";
		
		IEmployeeService service = new EmployeeServiceImpl();
		
		switch(choice) {
			case 1 :
				System.out.print("Enter the name : ");
				name = scanner.nextLine();

				System.out.print("Enter the Salary : ");
				salary = scanner.nextLine();

				System.out.print("Enter the address : ");
				address = scanner.nextLine();
				
				
				Employee employee = new Employee(name, Double.parseDouble(salary), address);
				
				Boolean flag = service.saveEmployee(employee);
				
				if(flag) {
					System.out.println("Record inserted succesfully");
				} else {
					System.out.println("Something went wrong plz try again....");
				}
				
		}
	}

}
