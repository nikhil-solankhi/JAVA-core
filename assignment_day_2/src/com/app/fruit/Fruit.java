package com.app.fruit;

public class Fruit {
	String name;
	String color;
	double weight;
	boolean fresh;

	public Fruit() {
	}

	public Fruit(String name, String color, double weight, boolean fresh) {
		super();
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.fresh = fresh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isFresh() {
		return fresh;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}

	public String taste() {
		return "no specific taste";
	}
}
