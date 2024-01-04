package mypackage4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage4.hibernate.entity.Student;

public class Main3_ReadStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			System.out.println("Creating new student object...");
			Student student_tmp = new Student("Arek", "Jozwiak", "myMail");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(student_tmp);
			
			session.getTransaction().commit();
			
			//Read
			System.out.println("Saved student. Generated id: "+ student_tmp.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting student with id: "+ student_tmp.getId());
			Student student = session.get(Student.class, student_tmp.getId());
			System.out.println("Get complete: " + student);
//			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally
		{
			session.close();
			factory.close();
		}
								
	}

}
