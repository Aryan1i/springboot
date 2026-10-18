package com.aryan.hibernate.entity;

import org.hibernate.envers.Audited;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Employee")
@Audited
public class Employee {
	@Id
	int eId;
	
	@Column(name = "empName")
	String eName;
	
	@Column(name = "empSalary")
	Double eSalary;
	
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Double geteSalary() {
		return eSalary;
	}

	public void seteSalary(Double eSalary) {
		this.eSalary = eSalary;
	}

	

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + "]";
	}

	public Employee() {
	}

	public Employee(int eId, String eName, Double eSalary) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSalary = eSalary;
	}
	
	
	
}
