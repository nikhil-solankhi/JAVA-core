package com.cdac.geometry;

public class Point2D {
	private int x;
	private int y;
	public Point2D() {
		
	}
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String show() {
		return "("+x+","+y+")";		
	}
	public boolean isEqual(Point2D p2) {
		if(this.x==p2.x && this.y==p2.y)
			return true;
		else
			return false;
	}
	public void calculateDistance(Point2D p2) {
		double d;
		d=Math.sqrt(Math.pow((p2.x-this.x),2)+Math.pow((p2.y-this.y),2));
		System.out.println(d);
	} 
}
