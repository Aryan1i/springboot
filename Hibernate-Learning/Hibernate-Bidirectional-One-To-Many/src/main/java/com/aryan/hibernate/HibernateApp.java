package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class HibernateApp {

	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class)
				.configure().buildSessionFactory();
		Session session = factory.openSession();

		Department department = session.find(Department.class, 100);
		
		System.out.println(department);
		
		for(Employee emp : department.getEmps()) {
			System.out.println(emp);
		}
		session.close();
		factory.close();
	}

}

//Output

/*
		
		Hibernate: 
		select
		    d1_0.did,
		    d1_0.dname 
		from
		    Department d1_0 
		where
		    d1_0.did=?
		Department [did=100, dname=IT]
		Hibernate: 
		select
		    e1_0.dnoFK,
		    e1_0.empId,
		    e1_0.empAddress,
		    e1_0.empName 
		from
		    empTab e1_0 
		where
		    e1_0.dnoFK=?
		Employee [eid=10, ename=sachin, eaddress=MI, depatment=Department [did=100, dname=IT]]
		Employee [eid=19, ename=dravid, eaddress=RCB, depatment=Department [did=100, dname=IT]]

*/