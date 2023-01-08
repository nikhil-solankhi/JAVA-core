package com.pojo_class;

public class BankAccount {
	
	private int accNo;
	private String name;
	private String address;
	private double balance;
	
	public BankAccount(int accNo, String name, String address, double balance) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.address = address;
		this.balance = balance;
	}

	public BankAccount(int empId) {
		this.accNo = empId;
	}
	
	public int getEmpId() {
		return accNo;
	}

	public void setEmpId(int empId) {
		this.accNo = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [AccNo=" + accNo + ", name=" + name + ", address=" + address + ", balance=" + balance + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof BankAccount) {
			return this.accNo == (((BankAccount)obj).accNo);
		}
		return false;
	}
	

}
