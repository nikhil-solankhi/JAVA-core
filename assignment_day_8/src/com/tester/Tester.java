package com.tester;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import com.app.*;

import com.validate.Validation;
import static utils.CustomerUtils.*;
import static com.validate.Validation.*;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase
			// get a populated AL<Customer>
			List<Customer> customerList = populateCustomerDetails();
			boolean exit = false;
			boolean depthExit_1 = false;
			int account_rec=0;

			Customer cust;
			while (!exit) {
				System.out.println("Options : \n1. Add a customer 2. Display all customers 3.Login Window 10. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter vehicle details : Name,  Email,  Password,Registration Amount,  manufactureDate(day/mon/yr),  Plan");
						Customer c = validateCustomerDetails(sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), sc.next(), customerList);
						customerList.add(c);
						System.out.println("Customer added");

						break;
					case 2:
						display(customerList);
						break;
					case 3:
						System.out.println("Login Window");
						System.out.println("Enter email  and  Password");
						cust = customerLogin(sc.next(), sc.next(), customerList);
						System.out.println("Login successfully");
						System.out.println("Options: \n1.Change Password 2.Buy a Plan 3.Unsubscribe 10.Logout");
						while (!depthExit_1) {
							try {
								switch (sc.nextInt()) {
								case 1:
									System.out.println("Enter old password");
									passwordMatching(sc.next(), cust);
									System.out.println("Enter new password");
									cust.setPassword(validatePassword(sc.next()));
									System.out.println("Password changed successfully");
									break;
								case 2:
									System.out.println("Enter plan name you want to buy Platinum,Silver,Gold");
									break;
								case 3:System.out.println("Unsubscribe");
									
								case 10:
									depthExit_1 = true;
									break;

								}
							} catch (Exception e) {
								e.printStackTrace();
								sc.nextLine();
							}
						}
						break;
					case 10:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}
