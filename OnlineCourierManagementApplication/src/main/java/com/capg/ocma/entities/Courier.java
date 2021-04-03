package com.capg.ocma.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courier")
public class Courier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int courierid;
	private int consignmentno;
	private LocalDate initiatedDate;
	private LocalDate deliveredDate;

	@Enumerated(EnumType.STRING)
	private CourierStatus status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer sender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer receiver;

	public Courier() {
		super();
	}

	public Courier(int courierid, int consignmentno, LocalDate initiatedDate, LocalDate deliveredDate,
			CourierStatus status, Customer sender, Customer receiver) {
		super();
		this.courierid = courierid;
		this.consignmentno = consignmentno;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getCourierid() {
		return courierid;
	}

	public void setCourierid(int courierid) {
		this.courierid = courierid;
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

	public CourierStatus getStatus() {
		return status;
	}

	public void setStatus(CourierStatus status) {
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

	@Override
	public String toString() {
		return "Courier [courierid=" + courierid + ", consignmentno=" + consignmentno + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", status=" + status + ", sender=" + sender
				+ ", receiver=" + receiver + "]";
	}

}
