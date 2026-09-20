package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class HIbernateChangeDepartment {

	public static void main(String[] args) {
		Session session = new Configuration().configure()
							.addAnnotatedClass(Department.class)
							.addAnnotatedClass(Employee.class)
							.buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		Department dpmt = session.find(Department.class, 100);
		Employee emp = session.find(Employee.class, 10);
		
		dpmt.addEmployee(emp);
		
		transaction.commit();
		session.close();
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
		Hibernate: 
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
		update
		    empTab 
		set
		    dnoFK=?,
		    empAddress=?,
		    empName=? 
		where
		    empId=?
		*/