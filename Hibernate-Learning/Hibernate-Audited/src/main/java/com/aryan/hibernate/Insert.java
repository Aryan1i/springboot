package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class Insert {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee e1 = new Employee(1, "Aryan", 50000.0);
        Employee e2 = new Employee(2, "Gagan", 40000.0);
        Employee e3 = new Employee(3, "Amrita", 60000.0);
        
        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        
		tx.commit();
		
		factory.close(); 
	}
}
