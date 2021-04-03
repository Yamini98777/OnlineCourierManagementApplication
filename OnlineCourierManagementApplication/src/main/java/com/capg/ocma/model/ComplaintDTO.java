package com.capg.ocma.model;

public class ComplaintDTO {

	private int complaintid;
	private int consignmentno;
	private String shortdescription;
	private String detaildescription;
	private CustomerDTO customer;

	public ComplaintDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComplaintDTO(int complaintid, int consignmentno, String shortdescription, String detaildescription, CustomerDTO customer) {
		super();
		this.complaintid = complaintid;
		this.consignmentno = consignmentno;
		this.shortdescription = shortdescription;
		this.detaildescription = detaildescription;
		this.customer = customer;
	}

	public int getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ComplaintDTO [complaintid=" + complaintid + ", consignmentno=" + consignmentno + ", shortdescription="
				+ shortdescription + ", detaildescription=" + detaildescription + ", customer=" + customer + "]";
	}

}
