package com.capg.ocma.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name="bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="account_no")
	private static int accountNo;
	
	@Column(name="account_Holder_Type")
	private String accountHolderName;
	
	@Column(name="account_Type")
	private String accountType;

	public BankAccount() {
		super();
	
	}

	public BankAccount(int accountNo, String accountHolderName, String accountType) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public static int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
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
