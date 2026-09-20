package com.aryan.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class HibernateUpdate {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee emp = new Employee();
		
		emp.setEid(2);
		emp.setEname("Gagan");
		emp.setEaddress("HR");
		emp.setEsalary(200000.0);
		
		Employee mergedEmp = session.merge(emp);
		
		transaction.commit();
		System.out.println(mergedEmp);
		
	}

}


//OUTPUT

/*Hibernate: 
select
e1_0.empId,
e1_0.empAddress,
e1_0.empName,
e1_0.empSalary 
from
empTab e1_0 
where
e1_0.empId=?
Hibernate: 
update
empTab 
set
empAddress=?,
empName=?,
empSalary=? 
where
empId=?
Employee [eid=2, ename=Gagan, eaddress=HR, esalary=200000.0]*/