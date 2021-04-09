package com.capg.ocma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="office_staff_member")
public class OfficeStaffMember 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="emp_id")
	private int empid;
	private String name;
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public OfficeStaffMember() {
		super();
	}
	
	public OfficeStaffMember(int empid, String name, Address address, String role) 
	{
		super();
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.role = role;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	@Override
	public String toString() 
	{
		return "OfficeStaffMember [empid=" + empid + ", name=" + name + ", address=" + address + ", role=" + role + "]";
	}
	
	
}
