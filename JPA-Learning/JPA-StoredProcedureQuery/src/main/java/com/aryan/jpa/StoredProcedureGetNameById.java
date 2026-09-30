package com.aryan.jpa;

import com.aryan.jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;

public class StoredProcedureGetNameById {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		
		EntityManager em = factory.createEntityManager();
		
		String storedProcedureName = "getEmployeeNameById";
		
		StoredProcedureQuery query = em.createStoredProcedureQuery(storedProcedureName, Employee.class);
		query.registerStoredProcedureParameter("empId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("empName", String.class, ParameterMode.OUT);
		
		query.setParameter("empId", 1);
		
		query.execute();
		
		String name = (String) query.getOutputParameterValue("empName");
		
		System.out.println(name);
		
		em.close();
		factory.close();
	}

}
