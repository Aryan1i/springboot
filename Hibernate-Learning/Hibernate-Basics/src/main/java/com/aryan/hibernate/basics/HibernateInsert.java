package com.aryan.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class HibernateInsert {

	public static void main(String[] args) {
		Configuration configration = new Configuration();
		configration = configration.configure();
		SessionFactory factory = configration.buildSessionFactory();
		Session session = factory.openSession();
	
		Transaction transaction = session.beginTransaction();
		
		Employee emp = new Employee("Aryan", "BLR", 200000.0);
		session.persist(emp);
		
		transaction.commit();
	}
}


//Output

/*
Hibernate: 
drop table if exists empTab
Hibernate: 
create table empTab (
    empId integer not null auto_increment,
    empSalary float(53),
    empAddress varchar(255),
    empName varchar(255),
    primary key (empId)
) engine=InnoDB
Hibernate: 
insert 
into
    empTab
    (empAddress, empName, empSalary) 
values
    (?, ?, ?)
*/