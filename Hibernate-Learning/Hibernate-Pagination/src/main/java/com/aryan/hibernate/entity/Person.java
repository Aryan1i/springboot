package com.aryan.hibernate.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	private Integer pid;
	private String pname;
	private LocalDate pdob;
	private LocalTime ptom;
	private LocalDateTime pjdt;
	
	
	public Person() {
		super();
	}
	
	
	public Person(Integer pid, String pname, LocalDate pdob, LocalTime ptom, LocalDateTime pjdt) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdob = pdob;
		this.ptom = ptom;
		this.pjdt = pjdt;
	}
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public LocalDate getPdob() {
		return pdob;
	}
	public void setPdob(LocalDate pdob) {
		this.pdob = pdob;
	}
	public LocalTime getPtom() {
		return ptom;
	}
	public void setPtom(LocalTime ptom) {
		this.ptom = ptom;
	}
	public LocalDateTime getPjdt() {
		return pjdt;
	}
	public void setPjdt(LocalDateTime pjdt) {
		this.pjdt = pjdt;
	}
	
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pdob=" + pdob + ", ptom=" + ptom + ", pjdt=" + pjdt + "]";
	}
	
	
}
