package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;
import com.aryan.hibernate.entity.EmployeeBackUp;

public class HQLInsertEmployeeBackUp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(EmployeeBackUp.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hqlInsertQuery = """
									INSERT INTO EmployeeBackUp(eid, ename, eaddress, department)
									SELECT e.eid, e.ename, e.eaddress, e.department FROM Employee e
								""";
		MutationQuery query = session.createMutationQuery(hqlInsertQuery);
		
		int noOfRowAffected = query.executeUpdate();
		
		System.out.println("No of Row Affected:- " + noOfRowAffected);
		
		transaction.commit();
		session.close();
	}

}


//OUTPUT

/*
Hibernate: 
insert 
into
    empTabBackUp
    (empId, empName, empAddress, dnoFK) select
        e1_0.empId,
        e1_0.empName,
        e1_0.empAddress,
        e1_0.dnoFK 
    from
        empTab e1_0
No of Row Affected:- 5
*/