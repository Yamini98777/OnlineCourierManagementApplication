package com.capg.ocma.model;

import java.time.LocalDate;

import com.capg.ocma.entities.Customer;

public class CourierDTO {

	private int courierid;
	private String status;
	private Customer sender;
	private Customer receiver;
	private int consignmentno;

	private LocalDate initiatedDate;
	private LocalDate deliveredDate;

	public CourierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierDTO(int courierid, String status, Customer sender, Customer receiver, int consignmentno, LocalDate initiatedDate, LocalDate deliveredDate) {
		super();
		this.courierid = courierid;
		this.status = status;
		this.sender = sender;
		this.receiver = receiver;
		this.consignmentno = consignmentno;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
	}

	public int getCourierid() {
		return courierid;
	}

	public void setCourierid(int courierid) {
		this.courierid = courierid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getSender() {
		return sender;
	}

	public void setSender(Customer sender) {
		this.sender = sender;
	}

	public Customer getReceiver() {
		return receiver;
	}

	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}

	public int getConsignmentno() {
		return consignmentno;
	}

	public void setConsignmentno(int consignmentno) {
		this.consignmentno = consignmentno;
	}

	public LocalDate getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(LocalDate initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Override
	public String toString() {
		return "CourierDTO [courierid=" + courierid + ", status=" + status + ", sender=" + sender + ", receiver="
				+ receiver + ", consignmentno=" + consignmentno + ", initiatedDate=" + initiatedDate
				+ ", deliveredDate=" + deliveredDate + "]";
	}

}
