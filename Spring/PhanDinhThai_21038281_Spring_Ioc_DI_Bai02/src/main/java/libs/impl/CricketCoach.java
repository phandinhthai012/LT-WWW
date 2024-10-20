package libs.impl;

import libs.Coach;
import libs.FortuneService;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmail");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "CricketCoach: Practice fast bowling for 15 minutes";
	}
	private FortuneService fortuneService;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public CricketCoach(String emailAddress, String team, FortuneService fortuneService) {
		super();
		this.emailAddress = emailAddress;
		this.team = team;
		this.fortuneService = fortuneService;
	}

	public CricketCoach() {
		super();
	}
	
}
