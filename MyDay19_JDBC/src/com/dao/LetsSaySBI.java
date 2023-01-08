package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dal.Interface_BA;
import com.excp.InsufficientFundsException;
import com.pojo_class.BankAccount;

public class LetsSaySBI implements Interface_BA {

	Connection connection;
	PreparedStatement pGetAllAccounts, pCreateANewAccount, pUpdateBankAccount, pDeleteBankAccount, pWithdrawAmount,
			pDepositAmount, pFundTransfer, pGetAccount;

	public LetsSaySBI() throws SQLException {

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
		System.out.println("<== CONNECTED TO SBI ==>");
		pGetAllAccounts = connection.prepareStatement("select * from accounts");
		pCreateANewAccount = connection.prepareStatement("insert into accounts values(?,?,?,?)");
		pUpdateBankAccount = connection
				.prepareStatement("update accounts" + " set name=?, address=?" + " where AccNo=?");
		pDeleteBankAccount = connection.prepareStatement("delete from accounts" + " where AccNo=?");
		pWithdrawAmount = connection.prepareStatement("update accounts" + " set balance=?" + " where AccNo=?");
		pDepositAmount = connection.prepareCall("update accounts" + " set balance=?" + " where AccNo=?");

		// pFundTransfer = connection.prepareCall("update bank" +" set balance=?" + "
		// where id=?; " + "update bank" +" set balance=?" + " where id=?");

	}

	@Override
	public BankAccount getAccount(int accno) throws SQLException {
		// TODO Auto-generated method stub
		pGetAccount = connection.prepareStatement("select * from accounts where AccNo=" + accno);
		BankAccount retreiveAccount = null;
		ResultSet resultSett = pGetAccount.executeQuery();
//		while (resultSet.next()) {
		resultSett.next();
		retreiveAccount = new BankAccount(resultSett.getInt(1), resultSett.getString(2), resultSett.getString(3),
				resultSett.getDouble(4));
//		}

		return retreiveAccount;
	}

	@Override
	public List<BankAccount> getAllAccounts() throws SQLException {
		// TODO Auto-generated method stub
		List<BankAccount> list = new ArrayList<BankAccount>();
		ResultSet resultSet = pGetAllAccounts.executeQuery();
		while (resultSet.next()) {
			list.add(new BankAccount(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4)));
		}

		return list;

	}

	@Override
	public String createaANewAcount(BankAccount account) throws SQLException {
		// TODO Auto-generated method stub
		pCreateANewAccount.setInt(1, account.getEmpId());
		pCreateANewAccount.setString(2, account.getName());
		pCreateANewAccount.setString(3, account.getAddress());
		pCreateANewAccount.setDouble(4, account.getBalance());

		int insertedRows = pCreateANewAccount.executeUpdate();

		if (insertedRows > 0)
			return "Inserted : " + account;
		else
			return null;
	}

	@Override
	public String updateBankAccount(BankAccount account) throws SQLException {
		// TODO Auto-generated method stub
		pUpdateBankAccount.setInt(3, account.getEmpId());
		pUpdateBankAccount.setString(1, account.getName());
		pUpdateBankAccount.setString(2, account.getAddress());

		int updatedRows = pUpdateBankAccount.executeUpdate();

		if (updatedRows > 0)
			return "updated account : " + account;
		else
			return null;
	}

	@Override
	public String deleteBankAccount(BankAccount account) throws SQLException {

		pDeleteBankAccount.setInt(1, account.getEmpId());

		int deletedRows = pDeleteBankAccount.executeUpdate();

		if (deletedRows > 0)
			return "deleted account : " + account;
		else
			return null;
	}

	@Override
	public String withdrawAmount(BankAccount account, double amount) throws SQLException, InsufficientFundsException {

		if (account.getBalance() < amount)
			throw new InsufficientFundsException("Insufficient funds, Can't Withdraw");

		pWithdrawAmount.setInt(2, account.getEmpId());
		pWithdrawAmount.setDouble(1, (account.getBalance() - amount));

		int updatedRows = pWithdrawAmount.executeUpdate();

		if (updatedRows > 0) {
			account = getAccount(account.getEmpId());
			return "updated account : " + account;
		} else
			return null;
	}

	@Override
	public String depositMoney(BankAccount account, double amount) throws SQLException {

		pDepositAmount.setInt(2, account.getEmpId());
		pDepositAmount.setDouble(1, (account.getBalance() + amount));

		int updatedRows = pDepositAmount.executeUpdate();

		if (updatedRows > 0) {
			account = getAccount(account.getEmpId());
			return "updated account : " + account;
		} else
			return null;
	}

	@Override
	public String fundsTransfer(BankAccount myAccount, BankAccount beneficiary, double amount)
			throws SQLException, InsufficientFundsException {

		if (myAccount.getBalance() < amount)
			throw new InsufficientFundsException("Insuffcient funds, Can't withdraw");

		// Withdraw from account
		if (withdrawAmount(myAccount, amount) == null)
			return null;

		// deposit into beneficiary
		if (depositMoney(beneficiary, amount) == null) {
			return null;
		}

		return "funds transfered from account : " + myAccount + " \nto beneficiary : " + beneficiary;

	}

}
