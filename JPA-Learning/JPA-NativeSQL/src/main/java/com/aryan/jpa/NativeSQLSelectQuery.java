package com.aryan.jpa;

import java.util.List;

import com.aryan.jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureQuery;

public class NativeSQLSelectQuery {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		
		EntityManager em = factory.createEntityManager();
		
		String nativeSQL = "SELECT eid, ename, esal, eaddr FROM employee";
		
		Query query = em.createNativeQuery(nativeSQL, Employee.class);
		
		List<?> list = query.getResultList();
		list.forEach(System.out::println);
		
		em.close();
		factory.close();
	}

}


//OUTPUT

/*Hibernate: 
SELECT
eid,
ename,
esal,
eaddr 
FROM
employee
Employee [eid=1, ename=sachin, esal=50000.0, eaddress=MI]
Employee [eid=2, ename=surya, esal=21000.0, eaddress=MI]
Employee [eid=3, ename=dhoni, esal=45000.0, eaddress=CSK]
Employee [eid=4, ename=kohli, esal=48000.0, eaddress=RCB]
Employee [eid=5, ename=rohit, esal=45000.0, eaddress=DC]
Employee [eid=6, ename=david, esal=38000.0, eaddress=RR]
Employee [eid=7, ename=hardik, esal=42000.0, eaddress=MI]
Employee [eid=8, ename=gayle, esal=390000.0, eaddress=RCB]
Employee [eid=9, ename=ashwin, esal=35000.0, eaddress=CSK]
Employee [eid=10, ename=bhuvaneshwar, esal=28000.0, eaddress=SRH]
Employee [eid=11, ename=dhoni, esal=25000.0, eaddress=RCB]
Employee [eid=12, ename=bumrah, esal=23000.0, eaddress=MI]
Employee [eid=13, ename=gill, esal=22000.0, eaddress=GT]
Employee [eid=14, ename=gagan, esal=10000.0, eaddress=HR]*/