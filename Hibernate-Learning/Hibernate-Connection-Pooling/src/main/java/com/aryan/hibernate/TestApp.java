package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class TestApp {

	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
				.addAnnotatedClass(Employee.class)
				.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.close();
		factory.close();
	}

}
