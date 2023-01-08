package com.app.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class StringListADS {

	public static void main(String[] args) {
		ArrayList<String> string_list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String var;
		String check;
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("options:" + "\n1.Insert elements" + "\n2.Display all contents"
						+ "\n3.Search element and to find the element position in array if exists"
						+ "\n4.Uppercase elements starts with t+" + "\n5.Remove element" + "\n6.Sorting"
						+ "\n7.Removing elements contating letter \"T\"" + "\n10.Exit");
				switch (sc.nextInt()) {

				case 1:
					System.out
							.println("Enter elements(press enter after entering every element) and type quit to exit");
					boolean flag = true;
					do {
						var = sc.next();
						if (var.equalsIgnoreCase("quit"))
							flag = false;
						else
							string_list.add(var);
					} while (flag);
					break;
				case 2:
					System.out.println(" AL contents : " + string_list);
					break;

				case 3:
					System.out.println("Enter element you want to check if exist in list or not");
					var = sc.next();
					if (string_list.contains(var))
						System.out.println("Exists at index: " + string_list.indexOf(var));
					else
						System.out.println("Not Exists");
					break;
				case 4:
					for (String i : string_list) {
						if (i.startsWith("t"))
							string_list.set(string_list.indexOf(i), i.toUpperCase());
					}
					System.out.println(" AL contents : " + string_list);
					break;
				case 5:
					System.out.println("Enter index of element you want to remove from array");
					int varInt = sc.nextInt();
					if (varInt > 0 && varInt < (string_list.size())) {
						string_list.remove(varInt);
						System.out.println("Element at postition" + varInt + "has been removed");
					} else
						System.out.println("Entered index not exists");
					break;
				case 6:
					ArrayList<String> new_string_list = new ArrayList<>(string_list);
					System.out.println("New array list contents: " + new_string_list);
					Collections.sort(string_list);
					System.out.println("Old array list sorted: " + string_list);
					break;
				case 7:
					Iterator<String> itr = string_list.iterator();
					while (itr.hasNext()) {
						if (itr.next().contains("T"))
							itr.remove();
					}
					System.out.println("Items removed containing letter T");
					break;
				case 10:
					exit = true;
					break;
				default:
					System.out.println("Invalid input");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.nextLine();
		}
	}
}
