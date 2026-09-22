package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;
import com.aryan.hibernate.entity.EmployeeBackUp;

import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;


public class HQLNameQueryFindByAddress {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(EmployeeBackUp.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		try(session){
			Employee emp = session.createNamedQuery("Employee.findByAddress", Employee.class).setParameter("empAddress", "MI").getSingleResult();
			System.out.println(emp);
		} catch (Exception e){
			if(e instanceof NoResultException) {
				System.out.println("Record not found for the given ID");
			}
				
			if (e instanceof NonUniqueResultException) {
				System.out.println("More than one record is available for the given address");
			}
		}
	}

}
