package com.app.org;

public abstract class Emp {
	private int id;
	private String firstname;
	private String lastname;
	private int deptno;
	private double basic;
	private static int count = 1000;

	public Emp(String firstname, String lastname, int deptno, double basic) {
		super();
		this.id = ++count;
		this.firstname = firstname;
		this.lastname = lastname;
		this.deptno = deptno;
		this.basic = basic;
	}

	public Emp(String firstname, String lastname) {
		super();
		this.id = ++count;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getDeptno() {
		return deptno;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public static int getCount() {
		return count;
	}

	public abstract double computeNetSal();

	public String toString() {
		return "ID: " + id + " First Name: " + firstname + " Lastname: " + lastname + " Basic Salary " + basic;
	}

	public boolean equals(Emp emp) {
		if (emp.getFirstname().equals(this.getFirstname()) && emp.getLastname().equals(this.getLastname()))
			return true;
		return false;
	}

//	public static void decreCount() {
//		Emp.count =count-1;
//	}
}
