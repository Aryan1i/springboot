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
