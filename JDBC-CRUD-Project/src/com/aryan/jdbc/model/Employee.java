package com.aryan.jdbc.model;

public class Employee {
	private Integer eid;
	private String ename;
	private Double esal;
	private String eaddr;

	public Employee(String ename,Double esal,String eaddr){
		this.ename = ename;
		this.esal = esal;
		this.eaddr = eaddr;
	}
	
	
	Employee(){
		
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

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	
	
}
