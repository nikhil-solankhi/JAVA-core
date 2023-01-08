package com.tester;

import java.util.List;
import java.util.Scanner;

import com.dao.LetsSaySBI;

import com.pojo_class.*;
import static com.util.Validators.validateAccount;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {

			LetsSaySBI letsSaySBI = new LetsSaySBI();

			List<BankAccount> accountList = letsSaySBI.getAllAccounts();

			boolean exit = false;

			while (!exit) {
				System.out.println(
						"<=================================================================================================>");
				System.out.println("Menu1 :Show All Accounts.\r\n" + "Menu2: Create New Account.\r\n"
						+ "Menu3 :update Name email for specific BankAccount.\r\n"
						+ "Menu4 :Delete BankAccount for specific BankAccount.\r\n"
						+ "Menu5 :WithDraw Amount for specific BankAccount.\r\n"
						+ "MEnu6: Deposite Amount for specific BankAccount.\r\n"
						+ "Menu7: MoneyTransfer from one account into another account.\n" + "Menu0: EXIT");
				System.out.println(
						"<=================================================================================================>");
				try {
					switch (sc.nextInt()) {

					case 1: // Menu1 :Show All Accounts.

						letsSaySBI.getAllAccounts().forEach(a -> System.out.println(a));
						break;

					case 2: // Menu2: Create New Account.

						System.out.println("Enter accID, Name, Address, Balance");
						String resultOfOperation = letsSaySBI.createaANewAcount(
								new BankAccount(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble()));
						if (resultOfOperation != null) {
							System.out.println(resultOfOperation);
						} else {
							System.out.println("Can't create a new Account, SORRY :(");
						}
						break;

					case 3: // Menu3 :update Name email for specific BankAccount.

						System.out.println("Enter id of the account you want to edit");
						BankAccount ba = new BankAccount(sc.nextInt());
						ba = validateAccount(ba, accountList);

						System.out.println("Enter name and address of the account you want to edit");
						ba.setName(sc.next());
						ba.setAddress(sc.next());
						resultOfOperation = letsSaySBI.updateBankAccount(ba);
						if (resultOfOperation != null)
							System.out.println(resultOfOperation);
						else
							System.out.println("Cant update the details... Sorry");

						break;

					case 4: // Menu4 :Delete BankAccount for specific BankAccount.

						System.out.println("Enter id of the account you want to delete");
						ba = new BankAccount(sc.nextInt());
						ba = validateAccount(ba, accountList);
						resultOfOperation = letsSaySBI.deleteBankAccount(ba);
						if (resultOfOperation != null)
							System.out.println(resultOfOperation);
						else
							System.out.println("Cant delete your account... Sorry");

						break;

					case 5: // Menu5 :WithDraw Amount for specific BankAccount.

						System.out.println("Enter id of the account, you want to withdraw funds");
						ba = new BankAccount(sc.nextInt());
						ba = validateAccount(ba, accountList);
						System.out.println("Enter the amount you want to withdraw...");
						resultOfOperation = letsSaySBI.withdrawAmount(ba, sc.nextDouble());

						if (resultOfOperation != null)
							System.out.println(resultOfOperation);
						else
							System.out.println("Cant withdraw from your account... Sorry");

						break;

					case 6: // MEnu6: Deposit Amount for specific BankAccount.

						System.out.println("Enter id of the account, you want to deposit funds");
						ba = new BankAccount(sc.nextInt());
						ba = validateAccount(ba, accountList);
						System.out.println("Enter the amount you want to deposit...");
						resultOfOperation = letsSaySBI.depositMoney(ba, sc.nextDouble());

						if (resultOfOperation != null)
							System.out.println(resultOfOperation);
						else
							System.out.println("Cant deposit into your account... Sorry");
						break;

					case 7: // Menu7: MoneyTransfer from one account into another account.

						System.out.println("Enter ID of the payee");
						BankAccount payee = new BankAccount(sc.nextInt());
						payee = validateAccount(payee, accountList);
						System.out.println("Enter ID of the beneficiary");
						BankAccount beneficiary = new BankAccount(sc.nextInt());
						beneficiary = validateAccount(beneficiary, accountList);

						System.out.print("Enter the amount to be transfered : ");
						resultOfOperation = letsSaySBI.fundsTransfer(payee, beneficiary, sc.nextDouble());

						if (resultOfOperation != null)
							System.out.println(resultOfOperation);
						else
							System.out.println("Cant transfer funds... Sorry");
						break;

					case 0:
						System.out.println("EXITING BANK APP");
						exit = true;

					} // end of switch
				} catch (Exception exp) {
					exp.printStackTrace();
				}
				sc.nextLine();
			} // end of while

		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
