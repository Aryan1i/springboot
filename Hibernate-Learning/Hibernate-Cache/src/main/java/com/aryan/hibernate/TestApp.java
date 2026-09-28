package com.aryan.hibernate;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class TestApp {

	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
										.addAnnotatedClass(Employee.class)
										.configure().buildSessionFactory();
		
		
		Session session1 = factory.openSession();
		
		Employee emp1 = session1.find(Employee.class, 10); // session chache ---> sessionFactory Cache ----> DB
		System.out.println(emp1);
		
		Employee emp2 = session1.find(Employee.class, 10); // serve from session cache;
		System.out.println(emp2);
		
		session1.close();
		
		
		
		
		Session session2 = factory.openSession();
		
		Employee emp3 = session2.find(Employee.class, 10); // session2  --- > session factory cache
		System.out.println(emp3);
		
		session2.close();

		
		
		Session session3 = factory.openSession();
		Cache cache = factory.getCache();
		cache.evict(Employee.class);
		
		Employee emp4 = session3.find(Employee.class, 10);
		System.out.println(emp4); //session chache ---> sessionFactory Cache ----> DB
		
		factory.close();
	}
}

//OUTPUT

/*Hibernate: 
    select
        e1_0.empId,
        e1_0.empAddress,
        e1_0.empName 
    from
        empTab e1_0 
    where
        e1_0.empId=?
Employee [eid=10, ename=sachin, eaddress=MI]
Employee [eid=10, ename=sachin, eaddress=MI]
Employee [eid=10, ename=sachin, eaddress=MI]
Hibernate: 
    select
        e1_0.empId,
        e1_0.empAddress,
        e1_0.empName 
    from
        empTab e1_0 
    where
        e1_0.empId=?
Employee [eid=10, ename=sachin, eaddress=MI]

*/
