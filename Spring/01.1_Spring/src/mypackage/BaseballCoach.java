package mypackage;

public class BaseballCoach implements Coach {

	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService)
	{
		System.out.println("BaseballCoach constructor - fortuneService");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "BaseballCoach - getDailyWorkout";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}
}
