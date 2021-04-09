package com.capg.ocma.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="courier_office_outlet")
public class CourierOfficeOutlet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="office_id")
	private int officeId;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate openingTime;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate closingTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="staff_id")
	private List<OfficeStaffMember> staffmembers;

	public CourierOfficeOutlet() {
		super();
	}

	public CourierOfficeOutlet(int officeId, Address address, LocalDate openingTime, LocalDate closingTime, List<OfficeStaffMember> staffmembers) {
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

	public LocalDate getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalDate openingTime) {
		this.openingTime = openingTime;
	}

	public LocalDate getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalDate closingTime) {
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
