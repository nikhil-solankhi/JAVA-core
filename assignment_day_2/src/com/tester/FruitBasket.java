package com.tester;

import java.util.Scanner;
import com.app.fruit.*;

public class FruitBasket {
	public static void main(String[] args) {
		int count = 0, flagex, sizeCart;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter total number of fruits you want to add in your cart");
		Fruit[] fruits = new Fruit[input.nextInt()];
		System.out.println("Fruit menu please choose to add to your basket");
		System.out.println("1. Add Mango\n 2.Add Orange\n 3.Apple\n 4.Show cart\n 5.Mark fruit stale \n6. Enter the index you want special functionality\n10.Exit");
		sizeCart = fruits.length;
		boolean exit=false;
		flagex = sizeCart;
		do {
			switch (input.nextInt()) {
			case 1:
				if (count < fruits.length) {
					fruits[count] = new Mango();
					count++;
					System.out.println("Mango added to your cart, Total items in cart: " + count);
				} else {
					System.out.println("Basket full");
//					break;
				}
				break;
			case 2:
				if (count < fruits.length) {
					fruits[count] = new Orange();
					count++;
					System.out.println("Orange added to your cart, Total items in cart: " + count);
				} else {
					System.out.println("Basket full");
//					break;
				}
				break;
			case 3:
				if (count < fruits.length) {
					fruits[count] = new Apple();
					count++;
					System.out.println("Apple added to your cart, Total items in cart: " + count);
				} else {
					System.out.println("Basket full");
//					break;
				}
				break;
			case 4:
				System.out.println("Fruits in your cart");
				for (int i = 0; i < count; i++) {
					System.out.println((i + 1) + ") " + fruits[i].toString());
				}
				System.out.println("Total no. of Mango are  " + Mango.count);
				System.out.println("Total no. of Orange are " + Orange.count);
				System.out.println("Total no. of Apple are  " + Apple.count);
				break;
			case 5:
				System.out.println("Enter index of fruit you want to mark as stale");
				int ind = input.nextInt();
				if(ind<=count) {
					fruits[ind].setFresh(false);
				}
				break;
			case 6:System.out.println("Enter the index you want special functionality");
			int n = input.nextInt();
			if(n<=count) {
				if(fruits[n] instanceof Mango) {
					((Mango)fruits[n]).pulp();
				}
				else if(fruits[n] instanceof Apple) {
					((Apple)fruits[n]).jam();
				}
				else if(fruits[n] instanceof Orange) {
					((Orange)fruits[n]).juice();
				}
			}
				break;
			case 10:
				exit = true;
				break;
			default:
				System.out.println("Invalid selection please refer to provided menu");
			}
			flagex -= 1;
		} while (!exit || flagex>0);

	}
}
