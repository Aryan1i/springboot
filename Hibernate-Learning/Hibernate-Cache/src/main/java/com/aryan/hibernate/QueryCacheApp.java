package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class QueryCacheApp {
	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
										.addAnnotatedClass(Employee.class)
										.configure().buildSessionFactory();
		
		
		Session session1 = factory.openSession();
		
		session1.createQuery("FROM Employee", Employee.class).setCacheable(true).getResultList()
						.forEach(System.out :: println);    // session--- sessionFactory--> db
		session1.close();
		
		
		
		System.out.println("*************************");
		
		
		
		Session session2 = factory.openSession();
		
		session2.createQuery("FROM Employee", Employee.class).setCacheable(true).getResultList()
						.forEach(System.out :: println);     // sessionFactory--->session
		
		
		factory.close();
	}
}


//OUTPUT

/*
 * Hibernate: 
    select
        e1_0.empId,
        e1_0.empAddress,
        e1_0.empName 
    from
        empTab e1_0
Employee [eid=7, ename=dhoni, eaddress=CSK]
Employee [eid=10, ename=sachin, eaddress=MI]
Employee [eid=18, ename=kohli, eaddress=RCB]
*************************
Employee [eid=7, ename=dhoni, eaddress=CSK]
Employee [eid=10, ename=sachin, eaddress=MI]
Employee [eid=18, ename=kohli, eaddress=RCB]
*/
