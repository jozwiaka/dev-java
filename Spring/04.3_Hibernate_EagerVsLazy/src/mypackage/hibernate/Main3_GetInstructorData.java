package mypackage.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage.hibernate.entity.Instructor;
import mypackage.hibernate.entity.InstructorDetail;

public class Main3_GetInstructorData {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			int id = 2;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("instructorDetail = "+instructorDetail);
			System.out.println("instructor = "+instructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
								
	}

}
