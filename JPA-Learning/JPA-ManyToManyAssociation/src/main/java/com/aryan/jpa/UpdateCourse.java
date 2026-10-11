package com.aryan.jpa;

import java.util.Set;

import com.aryan.jpa.entity.Course;
import com.aryan.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateCourse {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-unit");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Student student = em.find(Student.class, 10);
		Set<Course> courses = student.getCourses();
		
		for(Course cource : courses) {
			if(cource.getCname().equals("jpa")) {
				student.remove(cource);
				break;
			}
		}
		
		Course spring = new Course(103, "spring", 4000.0); 
		student.addCourse(spring);
		
		tx.commit();
		
		System.out.println(student);
		
		em.close();
		factory.close();
	}

}

//output

/*Hibernate: 
    select
        s1_0.sid,
        s1_0.sname 
    from
        Student s1_0 
    where
        s1_0.sid=?
Hibernate: 
    select
        c1_0.sidFK,
        c1_1.cid,
        c1_1.cname,
        c1_1.cost 
    from
        student_course c1_0 
    join
        Course c1_1 
            on c1_1.cid=c1_0.cidFK 
    where
        c1_0.sidFK=?
Hibernate: 
    select
        s1_0.cidFK,
        s1_1.sid,
        s1_1.sname 
    from
        student_course s1_0 
    join
        Student s1_1 
            on s1_1.sid=s1_0.sidFK 
    where
        s1_0.cidFK=?
Hibernate: 
    insert 
    into
        Course
        (cname, cost, cid) 
    values
        (?, ?, ?)
Hibernate: 
    delete 
    from
        student_course 
    where
        sidFK=? 
        and cidFK=?
Hibernate: 
    insert 
    into
        student_course
        (sidFK, cidFK) 
    values
        (?, ?)
Student [sid=10, sname=Tendulkar, courses=[Course [cid=103, cname=spring, cost=4000.0], Course [cid=101, cname=java, cost=2000.0]]]*/
