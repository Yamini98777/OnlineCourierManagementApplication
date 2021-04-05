package com.capg.ocma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="customer_id")
	private int customerId;
	private int aadharNo;
	private String firstName;
	private String lastName;
	private int mobileNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="zip")
	private Address addr;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_no")
	private BankAccount acct;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, int aadharNo, String firstName, String lastName, Address addr, int mobileNo,
			BankAccount acct) {
		super();
		this.customerId = customerId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
		this.mobileNo = mobileNo;
		this.acct = acct;
	}

	public int getCustomerid() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAadharno() {
		return aadharno;
	}

	public void setAadharnNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileno(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public BankAccount getAcct() {
		return acct;
	}

	public void setAcct(BankAccount acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", aadharNo=" + aadharNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", addr=" + addr + ", mobileNo=" + mobileNo + ", acct=" + acct + "]";
	}

}
