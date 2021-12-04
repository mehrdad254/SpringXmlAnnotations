package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("\n >> TennisCoach inside default constructor");
	}
	
	
// --> Constructor Injection with @Autowired
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

//	---> Setter injection with @Autowired
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("\n >> TennisCoach inside setFortuneSevice");
//		this.fortuneService = fortuneService;
//	}
	
//	---> method injection with @Autowired
//	@Autowired
//	public void testMethod(FortuneService fortuneService) {
//		System.out.println("\n >> TennisCoach inside TestMethods");
//		this.fortuneService = fortuneService;
//	}

	

	public String getDailyWorkout() {
		return "Practice your backhand volly";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void initilized() {
		System.out.println("this is initilized method");
	}
	
	@PreDestroy
	public void destroyed() {
		System.out.println("this is destroy method");
	}
	
}
