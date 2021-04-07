package com.capg.ocma.model;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;

@Component
public class CustomerDTO {

	private int customerid;
	private long aadharno;
	private String firstname;
	private String lastname;
	private Address addr;
	private long mobileno;
	private BankAccount acct;

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(int customerid, long aadharno, String firstname, String lastname, Address addr, long mobileno, BankAccount acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr = addr;
		this.mobileno = mobileno;
		this.acct = acct;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public long getAadharno() {
		return aadharno;
	}

	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public BankAccount getAcct() {
		return acct;
	}

	public void setAcct(BankAccount acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", addr=" + addr + ", mobileno=" + mobileno + ", acct=" + acct + "]";
	}


	
	
}
