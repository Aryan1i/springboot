package com.aryan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aryan.hibernate.entity.Employee;

public class PaginationApp {

	public static void main(String[] args) {
		Session session = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
		
		Query<Employee> query =  session.createNamedQuery("Employee.findAll" , Employee.class);
		
		query.setFirstResult(5);
		query.setMaxResults(5);
		
		List<Employee> list = query.getResultList();
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
}
