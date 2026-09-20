package com.aryan.hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	
	@Id
	int personId;
	String perName;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "pidFK")
	Passport passport;
	
	public Person() {
		
	}
	
	public Person(int personId, String perName) {
		this.personId = personId;
		this.perName = perName;
	}

	public void addPassport(Passport passport) {
		this.passport = passport;
		passport.setPerson(this);
	}
	
	public void removePassport(Passport passport) {
		this.passport = null;
		passport.setPerson(null);
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", perName=" + perName + "]";
	}
	
	public Person(String perName) {
        this.perName = perName;
    }
	
}
