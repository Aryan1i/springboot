package com.aryan.hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Person;

public class DateAndTimeApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
										.configure()
										.addAnnotatedClass(Person.class)
										.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Person p = new Person(1, "Aryan", LocalDate.of(2026, 9, 24), LocalTime.of(3, 9), LocalDateTime.now());
		
		session.persist(p);
		
		transaction.commit();
		
		Person person = session.find(Person.class, 1);

		System.out.println("Person Details:");
		System.out.println(person);
		
		session.close();
		factory.close();
		
	}
}


//OUTPUT
/*
Hibernate: 
    drop table if exists Person
Hibernate: 
    create table Person (
        pdob date,
        pid integer not null,
        ptom time(0),
        pjdt datetime(6),
        pname varchar(255),
        primary key (pid)
    ) engine=InnoDB
Hibernate: 
    insert 
    into
        Person
        (pdob, pjdt, pname, ptom, pid) 
    values
        (?, ?, ?, ?, ?)
Person Details:
Person [pid=1, pname=Aryan, pdob=2026-09-24, ptom=03:09, pjdt=2026-09-24T03:14:38.839767]
		*/