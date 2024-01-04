package mypackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main3_aC3 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3_beanLifeCycle.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());		
		context.close();
	}

}
