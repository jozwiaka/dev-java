package mypackage6.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage6.hibernate.entity.Instructor;
import mypackage6.hibernate.entity.InstructorDetail;

public class Main2_Delete {

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
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println(instructor);
			if(instructor != null)
			{
				//Will also delete associated InstructorDetail object, because CascadeType.ALL
				session.delete(instructor);
			}
			
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
