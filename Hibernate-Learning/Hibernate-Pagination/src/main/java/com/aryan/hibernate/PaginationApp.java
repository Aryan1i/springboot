package com.aryan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aryan.hibernate.entity.Employee;

public class PaginationApp {

	public static void main(String[] args) {
		Session session = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
		
		Query<Employee> query =  session.createNamedQuery("Employee.findAll" , Employee.class);
		
		query.setFirstResult(5);
		query.setMaxResults(5); 
		
		List<Employee> list = query.getResultList();
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
}


//OUTPUT

/*
Hibernate: 
select
    e1_0.eid,
    e1_0.eaddr,
    e1_0.ename,
    e1_0.esal 
from
    employee e1_0 
order by
    e1_0.eid 
limit
    ?, ?
Employee{eid=6, ename='david', esal=38000.0, eaddr='RR'}
Employee{eid=7, ename='hardik', esal=42000.0, eaddr='MI'}
Employee{eid=8, ename='gayle', esal=390000.0, eaddr='RCB'}
Employee{eid=9, ename='ashwin', esal=35000.0, eaddr='CSK'}
Employee{eid=10, ename='bhuvaneshwar', esal=28000.0, eaddr='SRH'}
*/