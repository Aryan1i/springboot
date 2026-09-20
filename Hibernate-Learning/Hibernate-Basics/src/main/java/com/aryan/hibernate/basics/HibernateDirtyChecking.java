package com.aryan.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class HibernateDirtyChecking {

	public static void main(String[] args) {
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee emp = session.find(Employee.class, 1);
		System.out.println(emp);

		emp.setEsalary(500000.0);

		session.beginTransaction();
		transaction.commit(); //Dirty Cheaking

		System.out.println(emp);
	}
}


//OUTPUT

/* Hibernate: 
select
e1_0.empId,
e1_0.empAddress,
e1_0.empName,
e1_0.empSalary 
from
empTab e1_0 
where
e1_0.empId=?
Employee [eid=1, ename=Aryan, eaddress=BLR, esalary=200000.0]
Hibernate: 
update
empTab 
set
empAddress=?,
empName=?,
empSalary=? 
where
empId=?
Employee [eid=1, ename=Aryan, eaddress=BLR, esalary=500000.0]*/