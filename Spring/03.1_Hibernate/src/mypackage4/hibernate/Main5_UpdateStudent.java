package mypackage4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage4.hibernate.entity.Student;

public class Main5_UpdateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session = factory.getCurrentSession();
			session.beginTransaction();
			int studentId = 2;
			Student student = session.get(Student.class, studentId);
			System.out.println("Update firstName for student with id = " + student.getId());
			student.setFirstName("newFirstName2");
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='newEmail'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			session.close();
			factory.close();
		}
								
	}

}
