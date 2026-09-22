package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Stock;

public class TimeStamping {

	public static void main(String[] args) {
		Session session = new Configuration().configure().addAnnotatedClass(Stock.class).buildSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		
		Stock st = new Stock("AI", 1500.0, "NSE");
		System.out.println(st); 
		
		session.persist(st);
		
		tx.commit();
		
		System.out.println(st);
		
		tx = session.beginTransaction();
		
		st.setPrice(1800.0);
		st.setExchange("BSE");
		
		tx.commit();
		
		System.out.println(st);
	}

}
