package com.capg.ocma.model;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.Address;

@Component
public class CourierOfficeOutletDTO {

	
	private int officeId;
	private Address address;
	private String openingTime;
	private String closingTime;
	

	public CourierOfficeOutletDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierOfficeOutletDTO(int officeId, Address address, String openingTime, String closingTime) {
		super();

		this.officeId = officeId;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		
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

	@Override
	public String toString() {
		return "CourierOfficeOutletDTO [officeId=" + officeId + ", address=" + address + ", openingTime=" + openingTime
				+ ", closingTime=" + closingTime + "]";
	}

	

}