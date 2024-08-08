package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
		Student st = new Student();
		st.setId(113);
		st.setName("Chandan");
		st.setEmail("royc6549@gmail.com");
		st.setMarks(400);

		// Student State Object is transiant
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.save(st);

		// Studnet state Object is persistant

		s.beginTransaction().commit();
		// Studnet state Object will be remove from persistant
		s.evict(st);
		// than gc can collect your student object

	}

}
