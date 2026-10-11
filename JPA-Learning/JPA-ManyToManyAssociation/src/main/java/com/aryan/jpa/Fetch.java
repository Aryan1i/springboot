package com.aryan.jpa;

import com.aryan.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		
		Student student = em.find(Student.class, 10);
		if(student != null) {
			System.out.println(student);
		}
		
		em.close();
		factory.close();
	}

}
