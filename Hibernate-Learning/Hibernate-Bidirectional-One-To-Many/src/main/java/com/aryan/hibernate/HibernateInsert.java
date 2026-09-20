package com.aryan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Department;
import com.aryan.hibernate.entity.Employee;


public class HibernateInsert {

	public static void main(String[] args) {
		SessionFactory  factory = new Configuration()
									.addAnnotatedClass(Department.class)
									.addAnnotatedClass(Employee.class)
									.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Department dept1 = new Department();
		dept1.setDid(100);
		dept1.setDname("IT");
		
		Department dept2 = new Department();
		dept2.setDid(101);
		dept2.setDname("AI");
		
		Employee emp1 = new Employee();
		emp1.setEid(10);
		emp1.setEname("sachin");
		emp1.setEaddress("MI");
		
		
		Employee emp2 = new Employee();
		emp2.setEid(19);
		emp2.setEname("dravid");
		emp2.setEaddress("RCB");
		
		
		Employee emp3 = new Employee();
		emp3.setEid(7);
		emp3.setEname("dhoni");
		emp3.setEaddress("CSK");
		
		
		dept1.addEmployee(emp1);
		dept1.addEmployee(emp2);
		dept2.addEmployee(emp3);
		
		
		session.persist(dept1);
        session.persist(dept2);

		
		transaction.commit();
		session.close();
		factory.close();
	}

}


//OUTPUT

/*
 Hibernate: 
    alter table empTab 
       drop 
       foreign key FKsbpqjbjy6xw2jqq3t1rlgr58m
Hibernate: 
    drop table if exists Department
Hibernate: 
    drop table if exists empTab
Hibernate: 
    create table Department (
        did integer not null,
        dname varchar(255),
        primary key (did)
    ) engine=InnoDB
Hibernate: 
    create table empTab (
        dnoFK integer,
        empId integer not null,
        empAddress varchar(255),
        empName varchar(255),
        primary key (empId)
    ) engine=InnoDB
Hibernate: 
    alter table empTab 
       add constraint FKsbpqjbjy6xw2jqq3t1rlgr58m 
       foreign key (dnoFK) 
       references Department (did)
Hibernate: 
    insert 
    into
        Department
        (dname, did) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        empTab
        (dnoFK, empAddress, empName, empId) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        empTab
        (dnoFK, empAddress, empName, empId) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        Department
        (dname, did) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        empTab
        (dnoFK, empAddress, empName, empId) 
    values
        (?, ?, ?, ?)

*/
