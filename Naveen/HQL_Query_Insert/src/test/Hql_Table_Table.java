package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.NewStudent;

public class Hql_Table_Table {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String str = "insert into NewStudent(id,name,email,address) select s.id,s.name,s.email,s.address from OldStudent s";
		Query q = session.createQuery(str);
		int i = q.executeUpdate();

		System.out.println("No data dumped from old to new Table");
		session.close();
		sf.close();
	}
}
