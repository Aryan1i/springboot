package com.aryan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class ReadingMultipleColumns {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		String hqlQuery = "SELECT e.ename , e.eaddress FROM Employee e WHERE e.eid >=: empId";
		
		Query<Object[]> query = session.createQuery(hqlQuery, Object[].class);
		query.setParameter("empId", 15);
		
		List<Object[]> list = query.getResultList();
		
		System.out.println("No of records is : " + list.size());
		
		for(Object[] row : list) {
			for(Object obj : row) {
				System.out.println(obj);
			}
			System.out.println();
		}
		
		
		session.close();
		factory.close();
	}

}

//OUTPUT

/*
 * Hibernate: 
    select
        e1_0.empName,
        e1_0.empAddress 
    from
        empTab e1_0 
    where
        e1_0.empId>=?
No of records is : 4
ABD
RCB

kohli
RCB

dravid
RCB

rohit
MI

*/
