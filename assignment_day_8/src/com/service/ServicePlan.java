package com.service;

public enum ServicePlan {
	SILVER(500), GOLD(600), PLATINUM(800), DIAMOND(1000);

	private double servicePlanCost;

	private ServicePlan(double cost) {
		this.servicePlanCost = cost;
	}

	public double getServicePlanCost() {
		return servicePlanCost;
	}

}