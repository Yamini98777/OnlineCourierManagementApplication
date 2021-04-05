package com.capg.ocma.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="courier_office_outlet")
public class CourierOfficeOutlet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="office_id")
	private int officeId;
	private LocalTime openingTime;
	private LocalTime closingTime;
	
	@OneToOne(mappedBy = "office", cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy="office", cascade = CascadeType.ALL )
	private List<OfficeStaffMember> staffmembers;

	public CourierOfficeOutlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierOfficeOutlet(int officeId, Address address, LocalTime openingTime, LocalTime closingTime,
			List<OfficeStaffMember> staffmembers) {
		super();
		this.officeId = officeId;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.staffmembers = staffmembers;
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
		return staffmembers;
	}

	public void setStaffmembers(List<OfficeStaffMember> staffmembers) {
		this.staffmembers = staffmembers;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutlet [officeId=" + officeId + ", address=" + address + ", openingTime=" + openingTime
				+ ", closingTime=" + closingTime + ", staffmembers=" + staffmembers + "]";
	}

}
