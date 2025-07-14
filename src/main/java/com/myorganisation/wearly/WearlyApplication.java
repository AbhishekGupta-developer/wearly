package com.myorganisation.wearly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WearlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WearlyApplication.class, args);
	}

}
