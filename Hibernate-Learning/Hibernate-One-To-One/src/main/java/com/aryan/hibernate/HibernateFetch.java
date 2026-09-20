package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Passport;
import com.aryan.hibernate.entity.Person;

public class HibernateFetch {

	public static void main(String[] args) {
		Session session = new Configuration().configure()
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Passport.class)
				.buildSessionFactory().openSession();
		
		Person person = session.find(Person.class, 10);
		
		Passport passport = session.find(Passport.class, 101);
		
		System.out.println(person);
		System.out.println(passport);
		System.out.println(person.getPassport());
	}

}


//Output
	
	/*Hibernate: 
	select
	p1_0.personId,
	p1_0.pidFK,
	p1_0.perName 
	from
	Person p1_0 
	where
	p1_0.personId=?
	Hibernate: 
	select
	p1_0.pid,
	p2_0.personId,
	p2_0.perName,
	p1_0.pnum 
	from
	Passport p1_0 
	left join
	Person p2_0 
	    on p1_0.pid=p2_0.pidFK 
	where
	p1_0.pid=?
	Person [personId=10, perName=Sachin]
	Passport [pid=101, pnum=ABCX1273]
	Passport [pid=101, pnum=ABCX1273]
	*/