package com.xavigarcia;

import com.xavigarcia.service.AthleteService;
import com.xavigarcia.service.MedalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AthleteApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AthleteApplication.class, args);

		AthleteService athleteService = context.getBean(AthleteService.class);
		MedalService medalService = context.getBean(MedalService.class);

		athleteService.createAthlete();
		athleteService.testAthlete();

		medalService.createMedal();
		medalService.testMedal();
	}
}
