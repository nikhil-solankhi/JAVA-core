package com.app.fruit;

public class Mango extends Fruit {
	public static int count;
	
	public Mango() {
		super("Mango", "yellow", 15 , true);
		count++;
	}
	public String taste() {
		return "sweet";
	}
	public void pulp() {
		System.out.println("Name: "+this.getName()+"Color: "+this.getColor()+"Msg: "+this.taste());
	}
	public String toString() {
		return "Name: "+this.getName()+" Color :"+this.getColor()+" Weight: "+this.getWeight()+" Freshness: "+(this.isFresh()?" Fresh ":" Not Fresh ")+" Taste: "+this.taste();
				
	}
}
