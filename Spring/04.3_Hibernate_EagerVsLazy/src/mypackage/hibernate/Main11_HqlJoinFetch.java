package mypackage.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import mypackage.hibernate.entity.Course;
import mypackage.hibernate.entity.Instructor;
import mypackage.hibernate.entity.InstructorDetail;

public class Main11_HqlJoinFetch {

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
			
			session.beginTransaction();
			
			int id = 1;
			//Fix - Option 2: Hibernate query with HQL
			//Load instructor and all courses at once (HQL JOIN FETCH)
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i "
					+ "JOIN FETCH i.courses where i.id=:instructorId"
							, Instructor.class);
			query.setParameter("instructorId", id);
			Instructor instructor = query.getSingleResult();
			System.out.println("Instructor: "+instructor);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Session is closed");
			System.out.println("Courses: "+instructor.getCourses());
			
			System.out.println("Done!");
			
		}
		finally
		{
			session.close();
			factory.close();
		}
								
	}

}
