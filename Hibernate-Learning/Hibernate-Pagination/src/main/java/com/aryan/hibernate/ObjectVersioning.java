package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.CallerTune;


public class ObjectVersioning {

	public static void main(String[] args) {
		Session session = new Configuration().configure().addAnnotatedClass(CallerTune.class).buildSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		CallerTune ct = new CallerTune("ABC", "XYZ");
		session.persist(ct);
		
		transaction.commit();
		
		session.beginTransaction();
		System.out.println(ct);
		
		ct.setTuneName("DEF");
		ct.setMovieName("ZYX");
		ct.setCount(10);
		
		transaction.commit();
		
		System.out.println(ct);
		
	}

}

//OUTPUT

/*
 *Hibernate: 
    insert 
    into
        CallerTune
        (count, movieName, tuneName) 
    values
        (?, ?, ?)
CallerTune [tuneId=3, tuneName=ABC, movieName=XYZ, count=0]
Hibernate: 
    update
        CallerTune 
    set
        count=?,
        movieName=?,
        tuneName=? 
    where
        tuneId=? 
        and count=?
CallerTune [tuneId=3, tuneName=DEF, movieName=ZYX, count=1]
*/
