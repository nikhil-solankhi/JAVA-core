package com.utilsAPP;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.AcctType;
import com.app.BankAccount;
import com.custExcp.BankingException;



public class BankingUtils {
	public static final double MIN_BALANCE;
	static {
		MIN_BALANCE = 5000;
	}

	// add a static method for min bal validation
	public static double validateBalance(double balance) throws BankingException {
		if (balance < MIN_BALANCE)
			throw new BankingException("Insufficient Balance !!!!");
		return balance;}
	

	// add a static method to populate map with sample data
	public static Map<Integer, BankAccount> populateBankAccounts() throws BankingException {
		Map<Integer, BankAccount> accts = new HashMap<>();
		// String customerName, double balance, AcctType acType, LocalDate creationDate)
		// {
		System.out.println(accts.put(101,
				new BankAccount("Rama", validateBalance(10000), AcctType.SAVINGS, LocalDate.parse("2020-01-01"))));
		System.out.println(accts.put(10,
				new BankAccount("Rama", validateBalance(6000), AcctType.CURRENT, LocalDate.parse("2020-11-01"))));

		System.out.println(accts.put(15,
				new BankAccount("Shubham", validateBalance(100000), AcctType.FD, LocalDate.parse("2020-05-21"))));

		System.out.println(accts.put(60,
				new BankAccount("Riya", validateBalance(60000), AcctType.SAVINGS, LocalDate.parse("2020-11-11"))));

		System.out.println(accts.put(55,
				new BankAccount("Tejas", validateBalance(14000), AcctType.SAVINGS, LocalDate.parse("2020-04-27"))));
		return accts;
	}

	// add a static method to parse string --> enum
	public static AcctType validateAcctType(String type) {
		return AcctType.valueOf(type.toUpperCase());
	}

}
