package com.aryan.jpa;

import java.util.List;

import com.aryan.jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;

public class StoredProcedureGetEmployeeDetailsById {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		String storedProcedureName = "getEmployeeDetailsById";
		
		StoredProcedureQuery query = em.createStoredProcedureQuery(storedProcedureName, Employee.class);
		
		query.registerStoredProcedureParameter("id", Integer.class , ParameterMode.IN);
		
		query.setParameter("id", 1);
		
		query.execute();
		
		List<?> emps = query.getResultList();
		
		emps.forEach(System.out::println);
		
		em.close();
		factory.close();
	}

}
