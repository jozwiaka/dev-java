package mypackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main1_aC1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1_CricketCoach.xml");
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach.getEmail());
		System.out.println(cricketCoach.getTeam());
		
		context.close();
		

	}

}
