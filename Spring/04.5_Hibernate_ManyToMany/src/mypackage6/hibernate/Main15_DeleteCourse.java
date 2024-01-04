package mypackage6.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage6.hibernate.entity.Course;
import mypackage6.hibernate.entity.Instructor;
import mypackage6.hibernate.entity.InstructorDetail;
import mypackage6.hibernate.entity.Review;
import mypackage6.hibernate.entity.Student;

public class Main15_DeleteCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
		
			session.beginTransaction();
			
			int id_course = 24;
			session.delete(session.get(Course.class, id_course));
			
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
