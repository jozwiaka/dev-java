package mypackage.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage.hibernate.entity.Course;
import mypackage.hibernate.entity.Instructor;
import mypackage.hibernate.entity.InstructorDetail;

public class Main5_CreateInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			Instructor instructor = new Instructor("firstName1", "lastName1", "email1");
			InstructorDetail instructorDetail = new InstructorDetail("yt1", "hobby1");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			//CascadeType.ALL -> instructorDetail will also be saved
			session.save(instructor);
			
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
