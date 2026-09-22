package com.aryan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;
import com.aryan.hibernate.entity.EmployeeBackUp;

public class HQLNamedQueryFindAll {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(EmployeeBackUp.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
//		Query<Employee> query = session.createNamedQuery("Employee.findAll", Employee.class);
//		
//		List<Employee> list = query.getResultList();
//		
//		for(Employee emp : list) {
//			System.out.println(emp);
//		}
		
		session.createNamedQuery("Employee.findAll", Employee.class).getResultList().forEach(System.out::println);
		session.close();
	}

}
