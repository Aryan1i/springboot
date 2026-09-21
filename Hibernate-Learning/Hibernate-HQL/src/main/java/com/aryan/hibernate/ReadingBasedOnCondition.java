package com.aryan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;

public class ReadingBasedOnCondition {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		String hqlQuery = "FROM Employee e WHERE e.eid >=: empId";
		
		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
		
		query.setParameter("empId" , 15);
		
		List<Employee> list = query.getResultList();
		
		System.out.println("No of records is : " + list.size()); 
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		session.close();
		factory.close();
	}

}

//OUTPUT

/*
 * Hibernate: 
    select
        e1_0.empId,
        e1_0.dnoFK,
        e1_0.empAddress,
        e1_0.empName 
    from
        empTab e1_0 
    where
        e1_0.empId>=?
No of records is : 4
Hibernate: 
    select
        d1_0.did,
        d1_0.dname 
    from
        Department d1_0 
    where
        d1_0.did=?
Employee [eid=17, ename=ABD, eaddress=RCB, depatment=Department [did=101, dname=IT]]
Hibernate: 
    select
        d1_0.did,
        d1_0.dname 
    from
        Department d1_0 
    where
        d1_0.did=?
Employee [eid=18, ename=kohli, eaddress=RCB, depatment=Department [did=102, dname=AI]]
Employee [eid=19, ename=dravid, eaddress=RCB, depatment=Department [did=101, dname=IT]]
Employee [eid=45, ename=rohit, eaddress=MI, depatment=Department [did=101, dname=IT]]
*/
