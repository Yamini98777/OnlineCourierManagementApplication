package com.capg.ocma.model;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.Manager;


@Component
public class OfficeStaffMemberDTO 
{
	
	private int empid;
	private String name;
	private Address address;
	private String role;
	private CourierOfficeOutlet office;
	private Manager managerId;
	
	public OfficeStaffMemberDTO() {
		super();
	}

	public OfficeStaffMemberDTO(int empid, String name, Address address, String role, CourierOfficeOutlet office,
			Manager managerId) {
		super();
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.role = role;
		this.office = office;
		this.managerId = managerId;
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

	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "OfficeStaffMemberDTO [empid=" + empid + ", name=" + name + ", address=" + address + ", role=" + role
				+ ", office=" + office + ", managerId=" + managerId + "]";
	}
	
}