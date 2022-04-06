package com.example.spinetti_case_study;

import com.example.spinetti_case_study.repositories.UserRepository;
import com.example.spinetti_case_study.services.UserService;
import com.example.spinetti_case_study.services.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpinettiDominickCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpinettiDominickCaseStudyApplication.class, args);
	}


	//Second method of creating a bean
	@Bean
	public UserService userService(UserRepository userRepository) {
		return new UserServiceImpl(userRepository);
	}


}
