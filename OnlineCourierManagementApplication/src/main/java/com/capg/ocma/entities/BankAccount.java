package com.capg.ocma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	@Column(name="account_no")
	private long accountNo;
	
	@Column(name="account_Holder_Type")
	private String accountHolderName;
	
	@Column(name="account_Type")
	private String accountType;

	public BankAccount() {
		super();
	
	}

	public BankAccount(long accountNo, String accountHolderName, String accountType) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
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
		return "BankAccount [accountno=" + accountNo + ", accountHolderName=" + accountHolderName + ", accountType="
				+ accountType + "]";
	}

}
