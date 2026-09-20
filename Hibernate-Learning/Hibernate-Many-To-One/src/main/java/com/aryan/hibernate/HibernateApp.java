package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class HibernateApp {

	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class)
				.configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Employee employee = session.find(Employee.class, 10);
		System.out.println(employee);
		
		transaction.commit();
		session.close();
		factory.close();
	}

}

// WITHOUT FETCH TYPE LAZY

/*Hibernate: 
    select
        e1_0.empId,
        d1_0.did,
        d1_0.dname,
        e1_0.empAddress,
        e1_0.empName 
    from
        empTab e1_0 
    left join
        Department d1_0 
            on d1_0.did=e1_0.dnoFK 
    where
        e1_0.empId=?
Employee [eid=10, ename=sachin, eaddress=MI, depatment=Department [did=101, dname=AI]]
*/


//WITH FETCH TYPE LAZY

/*
 * 
 * */
