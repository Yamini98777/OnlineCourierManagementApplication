package com.capg.ocma.model;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.OfficeStaffMember;

@Component
public class CourierOfficeOutletDTO {
	private int officeId;
	private Address address;
	private LocalTime openingTime;
	private LocalTime closingTime;
	private List<OfficeStaffMember> staffMembers;

	public CourierOfficeOutletDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierOfficeOutletDTO(int officeid, Address address, LocalTime openingTime, LocalTime closingTime, List<OfficeStaffMember> staffmembers) {
		super();
		this.officeId = officeid;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.staffMembers = staffmembers;
	}

	public int getOfficeid() {
		return officeId;
	}

	public void setOfficeid(int officeid) {
		this.officeId = officeid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}

	public List<OfficeStaffMember> getStaffmembers() {
		return staffMembers;
	}

	public void setStaffmembers(List<OfficeStaffMember> staffmembers) {
		this.staffMembers = staffmembers;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutletDTO [officeid=" + officeId + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + ", staffmembers=" + staffMembers + "]";
	}

}
