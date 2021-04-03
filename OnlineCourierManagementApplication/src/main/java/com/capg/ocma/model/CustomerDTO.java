package com.capg.ocma.model;

public class CustomerDTO {

	private int customerid;
	private int aadharno;
	private String firstname;
	private String lastname;
	private AddressDTO addr;
	private int mobileno;
	private BankAccountDTO acct;

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(int customerid, int aadharno, String firstname, String lastname, AddressDTO addr, int mobileno, BankAccountDTO acct) {
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

	public int getAadharno() {
		return aadharno;
	}

	public void setAadharno(int aadharno) {
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

	public AddressDTO getAddr() {
		return addr;
	}

	public void setAddr(AddressDTO addr) {
		this.addr = addr;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public BankAccountDTO getAcct() {
		return acct;
	}

	public void setAcct(BankAccountDTO acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + "]";
	}

}
