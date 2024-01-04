package mypackage2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main1_aC1 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
		Coach coach = context.getBean("coach_Tennis", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		Coach coach2 = context.getBean("coach_Tennis",Coach.class);
		System.out.println(coach);
		System.out.println(coach2);	
		context.close();
	}

}
