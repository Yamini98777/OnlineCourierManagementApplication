package com.capg.ocma.model;

import java.time.LocalTime;
import java.util.List;

public class CourierOfficeOutletDTO {
	private int officeId;
	private AddressDTO address;
	private LocalTime openingTime;
	private LocalTime closingTime;
	private List<OfficeStaffMemberDTO> staffMembers;

	public CourierOfficeOutletDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierOfficeOutletDTO(int officeid, AddressDTO address, LocalTime openingTime, LocalTime closingTime, List<OfficeStaffMemberDTO> staffmembers) {
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
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

	public List<OfficeStaffMemberDTO> getStaffmembers() {
		return staffMembers;
	}

	public void setStaffmembers(List<OfficeStaffMemberDTO> staffmembers) {
		this.staffMembers = staffmembers;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutletDTO [officeid=" + officeId + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + ", staffmembers=" + staffMembers + "]";
	}

}
