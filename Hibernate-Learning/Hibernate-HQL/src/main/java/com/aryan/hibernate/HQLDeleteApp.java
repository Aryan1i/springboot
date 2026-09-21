package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class HQLDeleteApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hqlDeleteQuery = "DELETE FROM Employee e WHERE e.eid =: empId";
		
		MutationQuery query = session.createMutationQuery(hqlDeleteQuery);
		query.setParameter("empId", 18);
		
		int noOfRowAffected = query.executeUpdate();
		
		System.out.println("No of Row Affected:- " + noOfRowAffected);
		
		transaction.commit();
		session.close();
		
	}

}

//OUTPUT

/*
 * 
 * Hibernate: 
    delete e1_0 
    from
        empTab e1_0 
    where
        e1_0.empId=?
No of Row Affected:- 1
*/
