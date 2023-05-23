package com.ssafy.wwwfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WwWfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwWfitApplication.class, args);
	}

}
