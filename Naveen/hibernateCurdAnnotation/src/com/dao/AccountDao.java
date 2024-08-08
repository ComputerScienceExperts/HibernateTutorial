package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Account;
import com.util.SessionUtil;

public class AccountDao {
	@SuppressWarnings("finally")
	public Account get(long accno) {
		Session session = null;
		Account account = null;
		try {
			session = SessionUtil.getsession();
			account = (Account) session.get(Account.class, accno);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.closeSession(session);
			return account;
		}
	}

	public void insert(Account account) {
		Session session = null;
		try {
			session = SessionUtil.getsession();
			session.getTransaction().begin();
			session.save(account);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			SessionUtil.closeSession(session);
		}
	}

	public void update(Account account) {
		Session session = null;
		try {
			session = SessionUtil.getsession();
			session.getTransaction().begin();
			session.update(account);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			SessionUtil.closeSession(session);
		}
	}

	public void delete(long accno) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = SessionUtil.getsession();
			transaction = session.beginTransaction();
			Account account = (Account) session.get(Account.class, accno);
			session.delete(account);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			SessionUtil.closeSession(session);
		}
	}

}
