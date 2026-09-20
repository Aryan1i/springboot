package com.aryan.hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "empTab")
public class Employee {
	
	@Id
	@Column(name = "empId")
	private Integer eid;
	
	@Column(name = "empName")
	private String ename;
	
	@Column(name = "empAddress")
	private String eaddress;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "dnoFK")
	private Department depatment;
	
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

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	
	
	public Department getDepatment() {
		return depatment;
	}

	public void setDepatment(Department depatment) {
		this.depatment = depatment;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", depatment=" + depatment
				+ "]";
	}
	
}
