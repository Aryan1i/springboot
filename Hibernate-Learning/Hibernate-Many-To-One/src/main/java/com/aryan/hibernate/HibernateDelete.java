package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class HibernateDelete {

	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class)
				.configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Employee employee = session.find(Employee.class, 10);
		session.remove(employee);
		
		transaction.commit();
		session.close();
		factory.close();

	}

}


//Output
	
	/*
	 * Hibernate: 
	    select
	        e1_0.empId,
	        e1_0.dnoFK,
	        e1_0.empAddress,
	        e1_0.empName 
	    from
	        empTab e1_0 
	    where
	        e1_0.empId=?
	Hibernate: 
	    delete 
	    from
	        empTab 
	    where
	        empId=?
	*/
