package com.tester;

import java.util.List;
import java.util.Scanner;

import com.dao.LetsSaySBI;

import com.pojo_class.*;

public class tester1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {

			LetsSaySBI letsSaySBI = new LetsSaySBI();

			letsSaySBI.getAllAccounts().forEach(account -> System.out.println(account));
			List<BankAccount> accountList = letsSaySBI.getAllAccounts();
			String fundsTransfered = letsSaySBI.fundsTransfer(accountList.get(0), accountList.get(1), 2000);
			if (fundsTransfered != null) {
				System.out.println(fundsTransfered);
			}
			else
				System.out.println("Fund TransFer Failed");
			
			letsSaySBI.getAllAccounts().forEach(acc -> System.out.println(acc));
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
