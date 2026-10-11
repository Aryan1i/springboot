package com.aryan.jpa;

import java.util.Set;

import com.aryan.jpa.entity.Course;
import com.aryan.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Student student = em.find(Student.class, 10);
		em.remove(student);
		
		tx.commit();
		
		em.close();
		factory.close();
	}
}

//OUTPUT

/*Hibernate: 
select
s1_0.sid,
s1_0.sname 
from
Student s1_0 
where
s1_0.sid=?
Hibernate: 
delete 
from
student_course 
where
sidFK=?
Hibernate: 
delete 
from
Student 
where
sid=?
*/