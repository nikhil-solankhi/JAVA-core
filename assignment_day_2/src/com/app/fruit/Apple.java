package com.app.fruit;

public class Apple extends Fruit{
	public static int count;
	
	public Apple() {
		super("Apple", "Red", 25 , true);
		count++;
	}
	public String taste() {
		return "sweet n sour";
	}
	public void jam() {
		System.out.println("Name: "+this.getName()+"Color: "+this.getColor()+"Msg: "+this.taste());
	}
	public String toString() {
		return "Name: "+this.getName()+" Color :"+this.getColor()+" Weight: "+this.getWeight()+" Freshness: "+(this.isFresh()?" Fresh ":" Not Fresh ")+" Taste: "+this.taste();
		
	}
}
