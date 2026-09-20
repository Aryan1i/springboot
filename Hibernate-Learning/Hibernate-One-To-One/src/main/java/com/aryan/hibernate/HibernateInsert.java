package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Passport;
import com.aryan.hibernate.entity.Person;

public class HibernateInsert {

	public static void main(String[] args) {
		Session session = new Configuration().configure()
							.addAnnotatedClass(Person.class)
							.addAnnotatedClass(Passport.class)
							.buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Person person = new Person(10, "Sachin");
		
		Passport passport = new Passport(101, "ABCX1273");
		
		person.addPassport(passport);
		
		session.persist(person);
		
		transaction.commit();

        session.close();
		
	}

}

//OUTPUT

/*
 * 
 * Hibernate: 
    insert 
    into
        Passport
        (pnum, pid) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        Person
        (pidFK, perName, personId) 
    values
        (?, ?, ?)
*/
