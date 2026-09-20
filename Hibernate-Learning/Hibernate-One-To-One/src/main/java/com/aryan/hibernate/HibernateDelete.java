package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Passport;
import com.aryan.hibernate.entity.Person;

public class HibernateDelete {

	public static void main(String[] args) {
		Session session = new Configuration().configure()
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Passport.class)
				.buildSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		
		Person person = session.find(Person.class, 10);
		session.remove(person);
		
		transaction.commit();
		
	}

}


//OUTPUT
	
	/*
	Hibernate: 
	select
	    p1_0.personId,
	    p1_0.pidFK,
	    p1_0.perName 
	from
	    Person p1_0 
	where
	    p1_0.personId=?
	Hibernate: 
	delete 
	from
	    Person 
	where
	    personId=?
	Hibernate: 
	delete 
	from
	    Passport 
	where
	    pid=? 
	*/