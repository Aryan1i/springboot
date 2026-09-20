package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Passport;
import com.aryan.hibernate.entity.Person;

public class HibernateOrphanRemoval {

	public static void main(String[] args) {
		Session session = new Configuration().configure()
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Passport.class)
				.buildSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		Person person = session.find(Person.class, 10);
		
		person.removePassport(person.getPassport());
		
		transaction.commit();


        session.close();
	}

}
