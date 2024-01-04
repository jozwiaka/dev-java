package mypackage;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach()
	{
		System.out.println("TrackCoach constructor - no args");
	}
	
	public TrackCoach(FortuneService fortuneService) {
		//super();
		System.out.println("TrackCoach constructor - fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "TrackCoach - getDailyWorkout";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public void onStartup()
	{
		System.out.println("TrackCoach - onStartup");
	}
	
	public void onCleanup()
	{
		System.out.println("TrackCoach - onCleanup");
	}
}
