package com.aryan.jdbc.model;

public class Employee {
	private int eid;
	private String ename;
	private Double esal;
	private String eaddr;

	public Employee(String ename,Double esal,String eaddr){
		this.ename = ename;
		this.esal = esal; 
		this.eaddr = eaddr;
	}
	
	public Employee(int eid, String ename,Double esal,String eaddr){
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.eaddr = eaddr;
	}
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", eaddr=" + eaddr + "]";
	}

	public Employee(){
		
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
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
