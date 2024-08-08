package com.service;

import com.beans.Account;
import com.dao.AccountDao;

public class AccountService {
	public static void main(String[] args) {

		AccountDao dao = new AccountDao();

		/*
		 * // Retrieve Account Account rAccount = dao.get(90005);
		 * System.out.println("Account details ...."); System.out.println("Accno : " +
		 * rAccount.getAccno()); System.out.println("Name : " + rAccount.getName());
		 * System.out.println("8alance : " + rAccount.getBalance());
		 */

		// Create Account
		Account cAccount = new Account();
		cAccount.setAccno(90002);
		cAccount.setName("sekhar");
		cAccount.setBalance(6899);
		dao.insert(cAccount);
		System.out.println("Account created successfully");

		/*
		 * // Update Account Account uAccount = new Account(); uAccount.setAccno(90005);
		 * uAccount.setName("sekhareddy"); uAccount.setBalance(4500);
		 * dao.update(uAccount); System.out.println("Account updated successfully");
		 */

		/*
		 * // Delete Account dao.delete(90005);
		 * System.out.println("Account is deleted successfully");
		 */

	}

}
