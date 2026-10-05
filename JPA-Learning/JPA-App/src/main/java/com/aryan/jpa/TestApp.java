package com.aryan.jpa;

import com.aryan.jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestApp {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		
		EntityManager manager = factory.createEntityManager();
		
		Employee emp = manager.find(Employee.class, 1);
		System.out.println(emp);
		
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		emp.setEsal(50000.0);
		
		transaction.commit();
		
		System.out.println(emp);
		
		manager.close();
		factory.close();
		
	}

}


//OUTPUT

/*Hibernate: 
select
e1_0.eid,
e1_0.eaddr,
e1_0.ename,
e1_0.esal 
from
employee e1_0 
where
e1_0.eid=?
Employee [eid=1, ename=sachin, esal=35000.0, eaddress=MI]
Hibernate: 
update
employee 
set
eaddr=?,
ename=?,
esal=? 
where
eid=?
Employee [eid=1, ename=sachin, esal=50000.0, eaddress=MI]*/