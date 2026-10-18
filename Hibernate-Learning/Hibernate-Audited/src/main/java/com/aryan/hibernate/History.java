package com.aryan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import com.aryan.hibernate.entity.Employee;

public class History {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		AuditReader auditReader = AuditReaderFactory.get(session);
		
		List<Number> revisions = auditReader.getRevisions(Employee.class, 1);
		
		for (Number revision : revisions) {
			
            Employee employee = auditReader.find(Employee.class, 1, revision);

            System.out.println("Revision: " + revision);

            System.out.println(employee);
        }
		 
		factory.close(); 
	}

}
