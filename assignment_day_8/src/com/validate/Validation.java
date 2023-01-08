package com.validate;

import static com.app.Customer.sdf;
import static com.validate.Validation.parseAndValidateDob;
import static com.validate.Validation.validatePlan;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.Customer;
import com.customExc.CustomerHandlingExc;
import com.service.ServicePlan;

public class Validation {
	public static Date checkDate;
	static {
		try {
			checkDate = sdf.parse("1/1/1995");
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("err in static block" + e);
		}
	}

	public static String validateEmail(String emailId) throws CustomerHandlingExc {
		String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+(com|org)$";
		if (emailId.matches(pattern)) {
			return emailId;
		}
		throw new CustomerHandlingExc("Invalid Email...!");
	}

	public static String validatePassword(String password) throws CustomerHandlingExc {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		if (password.matches(pattern)) {
			return password;
		}
		throw new CustomerHandlingExc("Invalid Password...!");
	}

	public static Date parseAndValidateDob(String dob) throws ParseException, CustomerHandlingExc {
		Date dobDate = sdf.parse(dob);
		if (dobDate.before(checkDate)) {
			return dobDate;
		}

		throw new CustomerHandlingExc("You're not eligible [under age]...!");
	}

	public static String checkForDup(String emailId, List<Customer> custList) throws CustomerHandlingExc {
		Customer anotherCust = new Customer(emailId);
		if (custList.contains(anotherCust))
			throw new CustomerHandlingExc("Email already exists...!");
		return emailId;
	}

	public static ServicePlan validatePlan(String plan) throws CustomerHandlingExc {
		try {
			return ServicePlan.valueOf(plan.toUpperCase());
		} catch (IllegalArgumentException e) {
			StringBuilder sb = new StringBuilder("Available Plans \n ");
			sb.append(Arrays.toString(ServicePlan.values()) + "\n");
			sb.append("Choose correct plan !");
			// wrong plan
			throw new CustomerHandlingExc(sb.toString());
		}
	}

	// add static method to invoke all validation rules
	public static Customer validateCustomerDetails(String name, String emails, String pwd, double regAmount, String dob,
			String plan, List<Customer> list) throws CustomerHandlingExc, ParseException {
		validateEmail(emails);
		validatePassword(pwd);
		parseAndValidateDob(dob);
		validatePlan(plan);
		checkForDup(emails, list);
		return new Customer(name, validateEmail(emails), validatePassword(pwd), regAmount, parseAndValidateDob(dob),
				validatePlan(plan));
	}

}