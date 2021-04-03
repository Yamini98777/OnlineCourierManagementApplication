package com.capg.ocma.model;

public class OfficeStaffMemberDTO 
{
	protected int empid;
	protected String name;
	protected AddressDTO address;
	protected String role;
	protected CourierOfficeOutletDTO office;
	
	public OfficeStaffMemberDTO() {
		super();
	}
	
	public OfficeStaffMemberDTO(int empid, String name, AddressDTO address, String role, CourierOfficeOutletDTO office) 
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public CourierOfficeOutletDTO getOffice() {
		return office;
	}
	public void setOffice(CourierOfficeOutletDTO office) {
		this.office = office;
	}

	@Override
	public String toString() 
	{
		return "OfficeStaffMember [empid=" + empid + ", name=" + name + ", address=" + address + ", role=" + role
				+ ", office=" + office + "]";
	}
	
	
}
