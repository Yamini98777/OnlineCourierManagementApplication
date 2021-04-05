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
	private int consignmentno;
	private String shortdescription;
	private String detaildescription;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(int complaintId, int consignmentno, String shortdescription, String detaildescription,
			Customer customer) {
		super();
		this.complaintId = complaintId;
		this.consignmentno = consignmentno;
		this.shortdescription = shortdescription;
		this.detaildescription = detaildescription;
		this.customer = customer;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getConsignmentno() {
		return consignmentno;
	}

	public void setConsignmentno(int consignmentno) {
		this.consignmentno = consignmentno;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getDetaildescription() {
		return detaildescription;
	}

	public void setDetaildescription(String detaildescription) {
		this.detaildescription = detaildescription;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", consignmentno=" + consignmentno + ", shortdescription="
				+ shortdescription + ", detaildescription=" + detaildescription + ", customer=" + customer + "]";
	}

}
