package com.app.org;

public class Mgr extends Emp {
	private double perfBonus;

	public Mgr(String firstname, String lastname, int deptno, double basic, double perfBonus) {
		super(firstname, lastname, deptno, basic);
		this.perfBonus = perfBonus;
	}
	public Mgr(String firstname, String lastname) {
		super(firstname, lastname);
	}
	
	public double getPerfBonus() {
		return perfBonus;
	}

	public void setPerfBonus(double perfBonus) {
		this.perfBonus = perfBonus;
	}

	public double computeNetSal() {
		return super.getBasic() + perfBonus;
	}

	public String toString() {
		return super.toString() + " Performance bonus " + perfBonus;
	}

	public int getId() {
		return super.getId();
	}
}
