package com.capg.ocma.model;


import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.OfficeStaffMember;

@Component
public class CourierOfficeOutletDTO {

	private int officeStaffId;
	private int officeId;
	private Address address;
	private String openingTime;
	private String closingTime;
	private List<OfficeStaffMember> staffMembers;

	public CourierOfficeOutletDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierOfficeOutletDTO(int officeId, Address address, String openingTime, String closingTime, List<OfficeStaffMember> staffMembers) {
		super();

		this.officeId = officeId;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.staffMembers = staffMembers;
	}

	public int getOfficeStaffId() {
		return officeStaffId;
	}

	public void setOfficeStaffId(int officeStaffId) {
		this.officeStaffId = officeStaffId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public List<OfficeStaffMember> getStaffMembers() {
		return staffMembers;
	}

	public void setStaffMembers(List<OfficeStaffMember> staffMembers) {
		this.staffMembers = staffMembers;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutletDTO [officeStaffId=" + officeStaffId + ", officeId=" + officeId + ", address="
				+ address + ", openingTime=" + openingTime + ", closingTime=" + closingTime + ", staffMembers="
				+ staffMembers + "]";
	}

}
