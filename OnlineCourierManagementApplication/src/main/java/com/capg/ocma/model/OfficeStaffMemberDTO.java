package com.capg.ocma.model;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;


@Component
public class OfficeStaffMemberDTO 
{
	
	protected int empid;
	protected String name;
	protected Address address;
	protected String role;
	protected CourierOfficeOutlet office;
	
	public OfficeStaffMemberDTO() {
		super();
	}
	
	public OfficeStaffMemberDTO(int empid, String name, Address address, String role, CourierOfficeOutlet office) 
	{
		super();
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.role = role;
		this.office = office;
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
	public CourierOfficeOutlet getOffice() {
		return office;
	}
	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}

	@Override
	public String toString() 
	{
		return "OfficeStaffMember [empid=" + empid + ", name=" + name + ", address=" + address + ", role=" + role
				+ ", office=" + office + "]";
	}
	
	
}