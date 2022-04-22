package com.example.spinetti_case_study;

import com.example.spinetti_case_study.controller.ReportBugController;
import com.example.spinetti_case_study.repositories.ReportBugRepository;
import com.example.spinetti_case_study.repositories.UserRepository;
import com.example.spinetti_case_study.services.ReportBugService;
import com.example.spinetti_case_study.services.ReportBugServiceImpl;
import com.example.spinetti_case_study.services.UserService;
import com.example.spinetti_case_study.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpinettiDominickCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpinettiDominickCaseStudyApplication.class, args);
	}


	//Second method of creating a bean
	@Bean
	public UserService userService(UserRepository userRepository) {
		System.out.println("I am User Bean");
		return new UserServiceImpl(userRepository);

	}

	//use of lambda expression
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println("My application got started!!");
	}

	//add bean for reportbugcontroller
//	@Bean
//	public ReportBugService reportBugService(ReportBugRepository reportBugRepository) {
//		System.out.println("I am ReportBug Bean");
//		return new ReportBugServiceImpl(reportBugRepository);
//	}
}
