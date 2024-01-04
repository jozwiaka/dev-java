package mypackage4.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage4.hibernate.entity.Student;

public class Main4_QueryStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").list();
			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Jozwiak'").list();
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.email LIKE 'myMail%'").list();			
			displayStudents(students);
		}
		finally
		{
			session.close();
			factory.close();
		}
								
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) 
		{
			System.out.println(student);
		}
		System.out.println("----------------------------------");
	}

}
