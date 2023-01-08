package utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.validate.Validation.*;

import com.app.Customer;
import com.customExc.CustomerHandlingExc;
import com.service.ServicePlan;

public class CustomerUtils {
//add a static method to ret populated list of vehicles
	public static List<Customer> populateCustomerDetails() throws ParseException, CustomerHandlingExc {
		ArrayList<Customer> customers = new ArrayList<>(1000);
		// double basePrice, Date manufactureDate, String company
		customers.add(new Customer("Deeksha", "deeksha.sahu@gmail.com", "Deeksha@1", 500,
				parseAndValidateDob("2/5/1994"), ServicePlan.DIAMOND));

		customers.add(new Customer("Yash_Sh", "Yash_sh.sahu@gmail.com", "Yash@2", 600, parseAndValidateDob("1/5/1993"),
				ServicePlan.DIAMOND));

		customers.add(new Customer("Tanmay ", "Tanmay.sahu_@gmail.com", "Tanmay@3", 400,
				parseAndValidateDob("22/5/1992"), ServicePlan.GOLD));

		customers.add(new Customer("Mayank ", "Mayank.sahu_@gmail.com", "Mayank@4", 300,
				parseAndValidateDob("2/4/1994"), ServicePlan.PLATINUM));

		customers.add(new Customer("Doctor ", "Doctor.sahu_@gmail.com", "Doctor@5", 100,
				parseAndValidateDob("2/7/1991"), ServicePlan.SILVER));

		customers.add(new Customer("Nikhil ", "Nikhil.sahu_@gmail.com", "Nikhil@2", 800,
				parseAndValidateDob("20/8/1992"), ServicePlan.DIAMOND));
		return customers;
	}

	public static void display(List<Customer> customerList) {
		for (Customer c : customerList)
			System.out.println(c);
	}

	public static Customer customerLogin(String email, String pwd, List<Customer> list) throws CustomerHandlingExc {
		validateEmail(email);
		validatePassword(pwd);
		Customer cust = findByEmail(email, list);
		Customer validCust = passwordMatching(pwd, cust);
		return validCust;

	}

	public static Customer findByEmail(String email, List<Customer> list) throws CustomerHandlingExc {
		validateEmail(email);
		Customer cust = new Customer(email);
		int index = list.indexOf(cust);
		if (index == -1) {
			throw new CustomerHandlingExc("Invalid credentials");
		}
		return list.get(index);
	}

	public static Customer passwordMatching(String pwd, Customer validCust) throws CustomerHandlingExc {
//		validatePassword(pwd);
		if (validCust.getPassword().equals(pwd)) 
			return validCust;		
		throw new CustomerHandlingExc("Password not match");
	}
}
