package libs.impl;

import libs.Coach;
import libs.FortuneService;

public class TennisCoach implements Coach {
	private FortuneService theFortune;

	public TennisCoach(FortuneService theFortune) {
		this.theFortune = theFortune;
	}

	@Override
	public String getDailyWorkout() {
		String workout = "TennisCoach: Run a hard 5k, Practice your backhand volley";
		return workout;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortune.getFortune();
	}

}
