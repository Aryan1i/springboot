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

//OUTPUT

/*Hibernate: 
drop table if exists Stock
Hibernate: 
create table Stock (
    count integer not null,
    price float(53),
    stockId integer not null auto_increment,
    openingTime datetime(6) not null,
    updatedTime datetime(6) not null,
    StockName varchar(255),
    exchange varchar(255),
    primary key (stockId)
) engine=InnoDB
Stock [stockId=null, StockName=AI, price=1500.0, exchange=NSE, count=null, openingTime=null, updatedTime=null]
Hibernate: 
insert 
into
    Stock
    (StockName, count, exchange, openingTime, price, updatedTime) 
values
    (?, ?, ?, ?, ?, ?)
Stock [stockId=1, StockName=AI, price=1500.0, exchange=NSE, count=0, openingTime=2026-10-08T11:33:16.356150, updatedTime=2026-10-08T11:33:16.356192]
Hibernate: 
update
    Stock 
set
    StockName=?,
    count=?,
    exchange=?,
    price=?,
    updatedTime=? 
where
    stockId=? 
    and count=?
Stock [stockId=1, StockName=AI, price=1800.0, exchange=BSE, count=1, openingTime=2026-10-08T11:33:16.356150, updatedTime=2026-10-08T11:33:16.389441]
*/

