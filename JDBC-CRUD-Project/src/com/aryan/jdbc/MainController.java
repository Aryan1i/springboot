package com.aryan.jdbc;

import java.util.Scanner;

import java.util.List;
import com.aryan.jdbc.model.Employee;
import com.aryan.jdbc.service.EmployeeServiceImpl;
import com.aryan.jdbc.service.IEmployeeService;

public class MainController {

	public static void main(String[] args) {
		IEmployeeService service = new EmployeeServiceImpl();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("***********************************");
			System.out.println("SERVICES OFFERED BY JDBCAPP");
			System.out.println("***********************************");
			System.out.println("1. INSERT");
			System.out.println("2. SELECT BY ID");
			System.out.println("3. SELECT ALL");
			System.out.println("4. UPDATE");
			System.out.println("5. DELETE");
			System.out.println("6. EXIT");

			System.out.print("ENTER UR CHOICE  :: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			String name = "";
			String salary = "";
			String address = "";

			switch (choice) {
			case 1:
				System.out.print("Enter the name : ");
				name = scanner.nextLine();
				System.out.print("Enter the Salary : ");
				salary = scanner.nextLine();
				System.out.print("Enter the address : ");
				address = scanner.nextLine();

				Employee employee = new Employee(name, Double.parseDouble(salary), address);

				Boolean flag = service.saveEmployee(employee);

				if (flag) {
					System.out.println("Record inserted succesfully");
				} else {
					System.out.println("Something went wrong plz try again....");
				}

				break;

			case 2:
				System.out.println("Enter the id");
				int id = scanner.nextInt();

				Employee e = service.readById(id);
				if (e != null) {
					System.out.println("id :- " + e.getEid() + " name :- " + e.getEname() + " Salary : - " + e.getEsal()
							+ " Address :- " + e.getEaddr());
				} else {
					System.out.println("Invalid ID");
				}

				break;
			case 3:
				System.out.println("ALL EMPLOYEE DETAILS");
				List<Employee> employees = service.readALL();

				if (employees.size() == 0) {
					System.out.println("No Record Found");
				} else {
					for (Employee e1 : employees) {
						System.out.println("id :- " + e1.getEid() + " name :- " + e1.getEname() + " Salary : - "
								+ e1.getEsal() + " Address :- " + e1.getEaddr());
					}
				}
				break;
			case 4:
				System.out.println("Enter the id");
				id = scanner.nextInt();
				scanner.nextLine();

				e = service.readById(id);
				if (e != null) {
					String oldName = e.getEname();
					Double oldSalary = e.getEsal();
					String oldAddr = e.getEaddr();
					System.out.println("id :- " + e.getEid() + " name :- " + e.getEname() + " Salary : - " + e.getEsal()
							+ " Address :- " + e.getEaddr());

					System.out.println("Enter the new Name [Press enter if you dont want to update name]");

					String newName = scanner.nextLine();

					if (newName.isBlank()) {
						newName = oldName;
					}

					System.out.println("Enter the new Salary [Press enter if you dont want to update salary]");
					String salaryInput = scanner.nextLine();

					Double newSalary;

					if (salaryInput.isBlank()) {
						newSalary = oldSalary;
					} else {
						newSalary = Double.parseDouble(salaryInput);

						if (newSalary <= 0) {
							newSalary = oldSalary;
						}
					}

					System.out.println("Enter the new Address [Press enter if you dont want to update address]");
					String newAddr = scanner.nextLine();

					if (newAddr.isBlank()) {
						newAddr = oldAddr;
					}

					flag = service.update(new Employee(id, newName, newSalary, newAddr));

					if (flag) {
						System.out.println("Record updated successfully");
					} else {
						System.out.println("Something went wrong. Please try again...");
					}
					break;

				} else {
					System.out.println("Invalid ID");
				}
				break;
			case 5:
				System.out.println("Enter the id you want to delete");
				id = scanner.nextInt();
				boolean status = service.delete(id);
				if (status) {
					System.out.println("Deleted Succefully");
				} else {
					System.out.println("Somthing went worng");
				}

				break;
			case 6:
				System.out.println("Thank you for using the EMS services");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Please try again!");
			}
		}
	}

}
