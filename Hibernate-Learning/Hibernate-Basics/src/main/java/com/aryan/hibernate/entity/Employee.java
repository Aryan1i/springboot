package com.aryan.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "empTab")
public class Employee {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empId")
	private Integer eid;
	
	@Column(name = "empName")
	private String ename;
	
	@Column(name = "empAddress")
	private String eaddress;
	
	@Column(name = "empSalary")
	private Double esalary;
	
	public Employee() {
		
	}
	
	public Employee(Integer eid, String ename, String eaddress, Double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.esalary = esalary;
	}

	public Employee(String ename, String eaddress, Double esalary) {
		super();
		this.ename = ename;
		this.eaddress = eaddress;
		this.esalary = esalary;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public Double getEsalary() {
		return esalary;
	}


	public void setEsalary(Double esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", esalary=" + esalary + "]";
	}
	
	
}
