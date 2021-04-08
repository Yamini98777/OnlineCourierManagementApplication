package com.capg.ocma.model;

import com.capg.ocma.entities.Customer;

public class ComplaintDTO {

	private long complaintid;
	private long consignmentno;
	private String shortdescription;
	private String detaildescription;
	private Customer customer;

	public ComplaintDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComplaintDTO(long complaintid, long consignmentno, String shortdescription, String detaildescription, Customer customer) {
		super();
		this.complaintid = complaintid;
		this.consignmentno = consignmentno;
		this.shortdescription = shortdescription;
		this.detaildescription = detaildescription;
		this.customer = customer;
	}

	public long getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(long complaintid) {
		this.complaintid = complaintid;
	}

	public long getConsignmentno() {
		return consignmentno;
	}

	public void setConsignmentno(long consignmentno) {
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
		return "ComplaintDTO [complaintid=" + complaintid + ", consignmentno=" + consignmentno + ", shortdescription="
				+ shortdescription + ", detaildescription=" + detaildescription + ", customer=" + customer + "]";
	}

}
