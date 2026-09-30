package com.aryan.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "eid")
	private Integer eid;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "esal")
	private Double esal;
	
	@Column(name = "eaddr")
	private String eaddress;
	
	
	public Employee() {
		
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

	public Double getEsal() {
		return esal;
	}

	public void setEsal(Double esal) {
		this.esal = esal;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", eaddress=" + eaddress + "]";
	}

	
}
