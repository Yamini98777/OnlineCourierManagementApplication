package com.capg.ocma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int complaintId;
	private int consignmentNo;
	private String shortDescription;
	private String detailDescription;
	
	@OneToOne
	private Customer customer;

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(int complaintId, int consignmentNo, String shortDescription, String detailDescription,
			Customer customer) {
		super();
		this.complaintId = complaintId;
		this.consignmentNo = consignmentNo;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.customer = customer;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", consignmentNo=" + consignmentNo + ", shortDescription="
				+ shortDescription + ", detailDescription=" + detailDescription + ", customer=" + customer + "]";
	}

}
