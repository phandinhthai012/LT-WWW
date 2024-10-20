package libs.impl;

import libs.Coach;
import libs.FortuneService;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;

	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {

		return "spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
