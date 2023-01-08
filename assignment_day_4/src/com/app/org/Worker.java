package com.app.org;

public class Worker extends Emp {
	private float hoursWorked;
	private double hourlyrate;

	public Worker(String firstname, String lastname, int deptno, double basic, float hoursWorked, double hourlyrate) {
		super(firstname, lastname, deptno, basic);
		this.hoursWorked = hoursWorked;
		this.hourlyrate = hourlyrate;
	}
	public Worker(String firstname, String lastname) {
		super(firstname, lastname);
	}

	public double getHourlyrate() {
		return hourlyrate;
	}

	public double computeNetSal() {
		return (super.getBasic() + (hoursWorked * hourlyrate));
	}

	public String toString() {
		return super.toString() + " Hours Worked: " + hoursWorked + " Hourly Rate: " + hourlyrate;
	}
	public int getId() {
		return super.getId();
	}
}