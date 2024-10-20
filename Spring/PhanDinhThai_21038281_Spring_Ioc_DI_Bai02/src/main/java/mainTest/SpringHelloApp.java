package mainTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import libs.Coach;
import libs.impl.CricketCoach;

public class SpringHelloApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di/applicationContext.xml");
		
		
//		Coach theCoachTennis = context.getBean("myTennisCoach", Coach.class);
//		System.out.println(theCoachTennis.getDailyWorkout());
//		System.out.println(theCoachTennis.getDailyFortune());
		
		
//		Coach theCoachBaseball = context.getBean("myCoach", Coach.class);
//		System.out.println(theCoachBaseball.getDailyWorkout());
//		System.out.println(theCoachBaseball.getDailyFortune());
		
		
		CricketCoach myCoachCricket = (CricketCoach) context.getBean("myCricketCoach", Coach.class);
		System.out.println(myCoachCricket.getEmailAddress());
		System.out.println(myCoachCricket.getTeam());
		
		
		System.out.println("-------------------------------------------");
		CricketCoach theCoachCricket =context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(theCoachCricket.getEmailAddress());
		System.out.println(theCoachCricket.getTeam());
		System.out.println(theCoachCricket.getDailyWorkout());
		System.out.println(theCoachCricket.getDailyFortune());
	}
}
