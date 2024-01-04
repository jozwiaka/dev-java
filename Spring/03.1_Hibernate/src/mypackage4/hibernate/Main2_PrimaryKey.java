package mypackage4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage4.hibernate.entity.Student;

public class Main2_PrimaryKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try
		{
			System.out.println("Creating new student object...");
			Student student_tmp1 = new Student("Arek1", "Jozwiak1", "myMail1");
			Student student_tmp2 = new Student("Arek2", "Jozwiak2", "myMail2");
			Student student_tmp3 = new Student("Arek3", "Jozwiak3", "myMail3");
			
			session.beginTransaction();
			
			System.out.println("Saving the students...");
			session.save(student_tmp1);
			session.save(student_tmp2);
			session.save(student_tmp3);
			
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
