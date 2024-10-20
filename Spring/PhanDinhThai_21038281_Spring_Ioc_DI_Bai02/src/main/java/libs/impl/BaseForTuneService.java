package libs.impl;

import libs.FortuneService;

public class BaseForTuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		String fortune = "Today is your lucky day";
		return fortune;
	}

}
