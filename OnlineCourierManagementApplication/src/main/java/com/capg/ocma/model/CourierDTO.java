package com.capg.ocma.model;

import java.time.LocalDate;

public class CourierDTO {

	private int courierid;
	private CourierStatusDTO status;
	private CustomerDTO sender;
	private CustomerDTO receiver;
	private int consignmentno;

	private LocalDate initiatedDate;
	private LocalDate deliveredDate;

	public CourierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourierDTO(int courierid, CourierStatusDTO status, CustomerDTO sender, CustomerDTO receiver, int consignmentno, LocalDate initiatedDate, LocalDate deliveredDate) {
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

	public CourierStatusDTO getStatus() {
		return status;
	}

	public void setStatus(CourierStatusDTO status) {
		this.status = status;
	}

	public CustomerDTO getSender() {
		return sender;
	}

	public void setSender(CustomerDTO sender) {
		this.sender = sender;
	}

	public CustomerDTO getReceiver() {
		return receiver;
	}

	public void setReceiver(CustomerDTO receiver) {
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
