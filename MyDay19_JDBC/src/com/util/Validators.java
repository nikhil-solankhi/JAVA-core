package com.util;

import java.util.List;

import com.excp.AccountNotFoundException;
import com.pojo_class.BankAccount;

public class Validators {

	public static BankAccount validateAccount(BankAccount ba, List<BankAccount> accountList) throws AccountNotFoundException {
		
		if (accountList.indexOf(ba) <= -1) {
			throw new AccountNotFoundException("Given Account ID doesnt exist");
		}
		return accountList.get(accountList.indexOf(ba));
	}
}
