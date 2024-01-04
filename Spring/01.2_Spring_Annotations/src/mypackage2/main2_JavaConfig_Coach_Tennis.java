package mypackage2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main2_JavaConfig_Coach_Tennis {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config_Coach_Tennis.class);
		Coach coach = context.getBean("coach_Tennis", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());		
		context.close();
	}

}
