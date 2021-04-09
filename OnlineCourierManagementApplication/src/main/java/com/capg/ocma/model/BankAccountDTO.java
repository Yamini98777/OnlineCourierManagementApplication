package com.capg.ocma.model;

import org.springframework.stereotype.Component;

@Component
public class BankAccountDTO {

	private long accountNo;
	private String accountHolderName;
	private String accountType;

	public BankAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccountDTO(long accountno, String accountHolderName, String accountType) {
		super();
		this.accountNo = accountno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public long getAccountno() {
		return accountNo;
	}

	public void setAccountno(long accountno) {
		this.accountNo = accountno;
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
		return "BankAccountDTO [accountno=" + accountNo + ", accountHolderName=" + accountHolderName + ", accountType="
				+ accountType + "]";
	}

}
