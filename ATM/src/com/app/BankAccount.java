package com.app;

import java.time.LocalDate;
import static com.utilsAPP.BankingUtils.*;

import com.custExcp.BankingException;

public class BankAccount {
	
	private int acctNo;
	private String customerName;
	private double balance;
	private AcctType acType;
	private LocalDate creationDate;
	private static int idGen=101;

	// create a/c : ctor
	public BankAccount(String customerName, double balance, AcctType acType, LocalDate creationDate) {
		super();
		this.acctNo = idGen++;
		this.customerName = customerName;
		this.balance = balance;
		this.acType = acType;
		this.creationDate = creationDate;
	}
	

	public int getAcctNo() {
		return acctNo;
	}


	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public AcctType getAcType() {
		return acType;
	}


	public void setAcType(AcctType acType) {
		this.acType = acType;
	}


	public LocalDate getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}


	// get a/c summary
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", balance=" + balance + ", acType="
				+ acType + ", creationDate=" + creationDate + "]";
	}

	// deposit
	public void deposit(double amount) {
		this.balance += amount;
	}

	// withdraw
	public void withdraw(double amount) throws BankingException {
		validateBalance(this.balance - amount);
		this.balance -= amount;
	}

	// funds transfer
	public void transferFunds(double amount, BankAccount destAcct) throws BankingException {
		// this => src , arg => dest acct
		this.withdraw(amount);
		destAcct.deposit(amount);
	}
	// NO need of overriding of : hashCode n equals : since Key type (Integer) has
	// already followed the contract

}
