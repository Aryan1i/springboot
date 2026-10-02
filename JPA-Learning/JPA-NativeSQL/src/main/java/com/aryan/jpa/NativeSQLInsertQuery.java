package com.aryan.jpa;

import com.aryan.jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NativeSQLInsertQuery {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction transaction= em.getTransaction();
		transaction.begin();
		
		String nativeSQL = "insert into employee (eid, ename, esal, eaddr) VALUES (:empId, :empName, :empSal, :empAddr)";
		
		Query query =  em.createNativeQuery(nativeSQL, Employee.class);
		
		query.setParameter("empId", "14");
		query.setParameter("empName", "gagan"); 
		query.setParameter("empSal", 10000.0);
		query.setParameter("empAddr", "HR");
		
		int noOfRowAffected = query.executeUpdate();
		System.out.println(noOfRowAffected);
		
		transaction.commit();
		
		em.close();
		factory.close();
	}

}
