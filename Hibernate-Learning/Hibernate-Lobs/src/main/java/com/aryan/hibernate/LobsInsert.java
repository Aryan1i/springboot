package com.aryan.hibernate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;


public class LobsInsert {

	public static void main(String[] args) throws IOException {
		SessionFactory  factory = new Configuration()
										.addAnnotatedClass(Employee.class)
										.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String imageLoc = "/Users/aryangupta/Desktop/springboot/JDBC-Learning/src/Resources/Sachin-image.webp";
		String resumeLoc = "/Users/aryangupta/Desktop/springboot/JDBC-Learning/src/Resources/resume.txt";
		
		byte[] image = Files.readAllBytes(Path.of(imageLoc));
		char[] resume = Files.readString(Path.of(resumeLoc)).toCharArray();
		
		Employee emp = new Employee(1, "sachin", "CSK", image, resume);
		session.persist(emp);
		
		tx.commit();
		
		
		factory.close();
	}
}