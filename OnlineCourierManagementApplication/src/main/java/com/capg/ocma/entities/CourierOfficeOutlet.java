package com.capg.ocma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class CourierOfficeOutlet {
	
	@Id
	private int officeId;
	
	private String openingTime;
	
	private String closingTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	public CourierOfficeOutlet() {
		super();
	}

	public CourierOfficeOutlet(int officeId, Address address, String openingTime, String closingTime) {
		super();
		this.officeId = officeId;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeid(int officeId) {
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
		return "CourierOfficeOutlet [officeId=" + officeId + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + ", address=" + address + "]";
	}



}