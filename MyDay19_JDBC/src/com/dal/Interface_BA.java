package com.dal;

import java.sql.SQLException;
import java.util.List;

import com.excp.InsufficientFundsException;
import com.pojo_class.BankAccount;

public interface Interface_BA {
	
	List<BankAccount> getAllAccounts() throws SQLException;
	
	String createaANewAcount(BankAccount account) throws SQLException;
	
	String updateBankAccount(BankAccount account) throws SQLException ;
	
	String deleteBankAccount(BankAccount account) throws SQLException;
	
	String withdrawAmount(BankAccount account, double amount) throws SQLException, InsufficientFundsException;
	
	String depositMoney(BankAccount account, double amount) throws SQLException;
	
	String fundsTransfer(BankAccount myAccount, BankAccount anotherAccount, double amount) throws SQLException, InsufficientFundsException;

	BankAccount getAccount(int accno) throws SQLException;
	
}
