package com.aryan.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class HibernateL1Cache {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Employee emp1 = session.find(Employee.class, 1);
		System.out.println(emp1); //Serve from DATABASE
		
		Employee emp2 = session.find(Employee.class, 1);
		System.out.println(emp2); //Serve from L1 session cache
	}

}


//Output
/*
 * 
Hibernate: 
    select
        e1_0.empId,
        e1_0.empAddress,
        e1_0.empName,
        e1_0.empSalary 
    from
        empTab e1_0 
    where
        e1_0.empId=?
Employee [eid=1, ename=Aryan, eaddress=BLR, esalary=500000.0]
Employee [eid=1, ename=Aryan, eaddress=BLR, esalary=500000.0]

*/
