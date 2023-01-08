package com.app.fruit;

import com.app.fruit.Fruit;

public class Orange extends Fruit {
	public static int count;

	public Orange() {
		super("Orange", "santri", 20, true);
		count++;
	}

	public String taste() {
		return "sour";
	}

	public void juice() {
		System.out.println("Name: " + this.getName() + "Color: " + this.getColor() + "Msg: " + this.taste());
	}

	public String toString() {
		return "Name: " + this.getName() + " Color :" + this.getColor() + " Weight: " + this.getWeight()
				+ " Freshness: " + (this.isFresh() ? " Fresh " : " Not Fresh ") + " Taste: " + this.taste();
	}
}
