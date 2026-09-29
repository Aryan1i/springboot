package com.aryan.hibernate.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "empTab")
public class Employee {
	
	@Id
	@Column(name = "empId")
	private int eid;
	
	@Column(name = "empName")
	private String ename;
	
	@Column(name = "empAddress")
	private String eaddress;
	
	@Lob
	private byte[] image;
	
	@Lob
	private char[] resume;
	
	public Employee() {
		
	}
	
	public Employee(int eid, String ename, String eaddress, byte[] image, char[] resume) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.image = image;
		this.resume = resume;
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
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	@Override 
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + "]";
	}
	
}
