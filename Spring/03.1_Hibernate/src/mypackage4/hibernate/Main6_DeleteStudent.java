package mypackage4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage4.hibernate.entity.Student;

public class Main6_DeleteStudent {

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
//			int studentId = 1;
//			Student student = session.get(Student.class, studentId);
//			System.out.println("Delete student with id = " + student.getId());
//			session.delete(student);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
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
