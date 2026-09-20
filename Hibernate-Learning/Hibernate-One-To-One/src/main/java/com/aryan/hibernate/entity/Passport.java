package com.aryan.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Passport")
public class Passport {
	@Id
	private int pid;
	
	private String pnum;
	
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	public Passport() {
		
    }

	public Passport(int pid, String pnum) {
		super();
		this.pid = pid;
		this.pnum = pnum;
	}



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [pid=" + pid + ", pnum=" + pnum + "]";
	}
	
}
