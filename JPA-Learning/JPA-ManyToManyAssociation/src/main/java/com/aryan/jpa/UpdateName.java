package com.aryan.jpa;

import com.aryan.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateName {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Student student = em.find(Student.class, 10);
		if(student != null) {
			student.setSname("Tendulkar");
		}
		
		tx.commit();
		
		System.out.println(student);
		
		em.close();
		factory.close();
	}

}
