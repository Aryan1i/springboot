package com.aryan.jpa;

import com.aryan.jpa.entity.Course;
import com.aryan.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Student sachin = new Student(10, "sachin");
		Student kohli = new Student(18, "kohli");
		
		Course java = new Course(101, "java", 2000.0);
		Course jpa = new Course(102, "jpa", 3000.0);
		Course spring = new Course(103, "spring", 4000.0);
		
		sachin.addCourse(java);
		sachin.addCourse(jpa);
		
		em.persist(sachin);
		
		transaction.commit();
		em.close();
		factory.close();
	}

}
