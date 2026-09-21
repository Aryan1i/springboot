package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class HQLUpdateApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hqlUpdateQuery = "UPDATE Employee e SET e.ename =: empName WHERE e.eid =: empId";
		
		MutationQuery query = session.createMutationQuery(hqlUpdateQuery);
		query.setParameter("empName", "tendulkar");
		query.setParameter("empId", 10);
		
		int noOfRowAffected = query.executeUpdate();
		
		System.out.println("No of Row Affected:- " + noOfRowAffected);
		
		transaction.commit();
		session.close();
	}

}


//OUTPUT
	
	/*
	Hibernate: 
	update
	    empTab e1_0 
	set
	    empName=? 
	where
	    e1_0.empId=?
	No of Row Affected:- 1
	*/