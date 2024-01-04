package mypackage6.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage6.hibernate.entity.Course;
import mypackage6.hibernate.entity.Instructor;
import mypackage6.hibernate.entity.InstructorDetail;
import mypackage6.hibernate.entity.Review;
import mypackage6.hibernate.entity.Student;

public class Main12_CreateCourseAndStudents {

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
			
			Course course = new Course("CourseReview1");
			
			session.save(course);
			
			Student student1 = new Student("firstName1", "lastName1","mail1");
			Student student2 = new Student("firstName2", "lastName2","mail2");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
			System.out.println(course.getStudents());
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
