package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class Update {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee e1 = session.find(Employee.class, 1);
		e1.seteSalary(100000.0);
        
		tx.commit();
		
		factory.close(); 
	}

}
