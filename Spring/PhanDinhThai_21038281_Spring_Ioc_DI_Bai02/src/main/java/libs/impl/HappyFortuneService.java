package libs.impl;

import libs.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day! You will win a million dollars!";
	}

}
