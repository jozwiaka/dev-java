package mypackage6.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage6.hibernate.entity.Instructor;
import mypackage6.hibernate.entity.InstructorDetail;

public class Main1_Create {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
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
