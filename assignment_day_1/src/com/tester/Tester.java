package com.tester;

import java.util.Scanner;

import com.cdac.geometry.Point2D;

public class Tester {

	public static void main(String[] args) {
		int x = 0, y = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of points you want to enter");
		Point2D[] points = new Point2D[input.nextInt()];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point2D();
			System.out.println("Enter point P" + (i + 1));
			System.out.print("Coordinate X:");
			points[i].setX(input.nextInt());
			System.out.print("Coordinate Y:");
			points[i].setY(input.nextInt());
		}

		System.out.println("Displaying Points");
		for (int i = 0; i < points.length; i++) {
			System.out.println((i+1)+") Point P" + (i + 1) + points[i].show());
		}
		System.out.println();
		
		System.out.println("Select 2 points from above entered");
		System.out.println("Select first point");
		int ps1=input.nextInt()-1;
		
		System.out.println("Select second point");
		int ps2=input.nextInt()-1;
		boolean check = points[ps1].isEqual(points[ps2]);
		if (check == false) {
			System.out.print("Distance between P"+(ps1+1)+" and P"+(ps2+1)+": ");
			points[ps1].calculateDistance(points[ps2]);
			System.out.println();
		} else if (check == true)
			System.out.println("Points are equal.");
		
		System.out.println("Enter 2 indices");
		System.out.println("Point P1");
		Point2D p1 = new Point2D();
		System.out.print("Coordinate X:");
		p1.setX(input.nextInt());
		System.out.print("Coordinate Y:");
		p1.setY(input.nextInt());
		System.out.println();

		System.out.println("Point P2");
		Point2D p2 = new Point2D();
		System.out.print("Coordinate X:");
		p2.setX(input.nextInt());
		System.out.print("Coordinate Y:");
		p2.setY(input.nextInt());
		check = p1.isEqual(p2);
		if (check == false) {
			System.out.print("Distance between P1 and P2: ");
			p1.calculateDistance(p2);
			System.out.println();
		} else if (check == true)
			System.out.println("Points are equal.");
	}

}
