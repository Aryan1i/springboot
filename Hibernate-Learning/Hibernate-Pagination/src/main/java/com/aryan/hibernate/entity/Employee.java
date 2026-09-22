package com.aryan.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")

@NamedQuery(name = "Employee.findAll", query = "FROM Employee e ORDER BY e.eid")
public class Employee {

    @Id
    private int eid;

    private String ename;
    private double esal;
    private String eaddr;

    public Employee() {
    }

    public Employee(int eid, String ename, int esal, String eaddr) {
        this.eid = eid;
        this.ename = ename;
        this.esal = esal;
        this.eaddr = eaddr;
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

    public double getEsal() {
        return esal;
    }

    public void setEsal(int esal) {
        this.esal = esal;
    }

    public String getEaddr() {
        return eaddr;
    }

    public void setEaddr(String eaddr) {
        this.eaddr = eaddr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esal=" + esal +
                ", eaddr='" + eaddr + '\'' +
                '}';
    }
}