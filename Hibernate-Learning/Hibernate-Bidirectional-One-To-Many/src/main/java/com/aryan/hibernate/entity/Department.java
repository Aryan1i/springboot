package com.aryan.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	private int did;
	private String dname;
	
	@OneToMany(mappedBy = "department" ,cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Employee> emps = new ArrayList<>();
	
	public void addEmployee(Employee emp) {
		emps.add(emp);
		emp.setDepatment(this);
	}
	
	
	public void removeEmployee(Employee emp) {
		emps.remove(emp);
		emp.setDepatment(null);
	}
	
	public Department() {
		
	}

	public Department(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + "]";
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}


	public List<Employee> getEmps() {
		return emps;
	}


	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	 
}
