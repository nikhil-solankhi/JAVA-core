package com.app;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.service.ServicePlan;

public class Customer implements Comparable<Customer> {
	// state: non static data members
	private int customerId;
	private String name;
	private String emailId;
	private String password;
	private double regAmount;
	private Date dob;
	private ServicePlan plan;
	// state: static data members
	public static SimpleDateFormat sdf;
	private static int idGenerator;
	// static init block
	static {
		idGenerator = 1000;
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public Customer(String name, String emailId, String password, double regAmount, Date date, ServicePlan plan) {
//		super();
		this.customerId = ++idGenerator;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = date;
		this.plan = plan;
	}

	public Customer(String emailId) {
		super();
		this.emailId = emailId;
	}
	public Customer(String pwd,int dum) {
		super();
		this.password = pwd;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		Customer.sdf = sdf;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		Customer.idGenerator = idGenerator;
	}

	@Override
	public String toString() {
		return "Customer[customerId= " + customerId + " ,name= " + name + " ,email= " + emailId + " ,dob= "
				+ sdf.format(dob) + " ,plan= " + plan + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer)
			return this.emailId.equals(((Customer) o).emailId);
		return false;

	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		return this.emailId.compareTo(anotherCustomer.emailId);
	}

}