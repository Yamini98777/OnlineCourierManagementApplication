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
	private int courierId;
	private int consignmentNo;
	private LocalDate initiatedDate;
	private LocalDate deliveredDate;

//	@Enumerated(EnumType.STRING)
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sendercourierId")
	private Customer sender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receivercourierId")
	private Customer receiver;

	public Courier() {
		super();
	}

	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate,
			String status, Customer sender, Customer receiver) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
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

	@Override
	public String toString() {
		return "Courier [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", status=" + status + ", sender=" + sender
				+ ", receiver=" + receiver + "]";
	}

}
