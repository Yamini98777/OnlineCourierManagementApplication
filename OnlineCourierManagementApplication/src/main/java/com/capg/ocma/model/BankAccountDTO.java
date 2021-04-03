package com.capg.ocma.model;

public class BankAccountDTO {

	private int accountno;
	private String accountHolderName;
	private String accountType;

	public BankAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccountDTO(int accountno, String accountHolderName, String accountType) {
		super();
		this.accountno = accountno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [accountno=" + accountno + ", accountHolderName=" + accountHolderName + ", accountType="
				+ accountType + "]";
	}

}
