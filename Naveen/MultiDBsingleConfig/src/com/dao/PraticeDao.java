package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Account;
import com.util.ConnectionUtil;

public class PraticeDao {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/mapping/Account.hbm.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		// Mysql
		Session mysqlSession = (Session) ConnectionUtil.getMysqlConnection();
		Account mysqlAccount = (Account) mysqlSession.get(Account.class, 90005);
		System.out.println("Mysq1 Account table details ....");
		System.out.println("Accno : " + mysqlAccount.getAccno());
		System.out.println("Name : " + mysqlAccount.getName());
		System.out.println("Balance : " + mysqlAccount.getBalance());

	}
}
