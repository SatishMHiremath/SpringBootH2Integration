package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

//@ComponentScan("com.example")
//@SpringBootApplication(scanBasePackages = "com.example")
//@EnableJpaRepositories
@SpringBootApplication
public class BootRestApplication 
//implements ApplicationRunner 
{

	public static void main(String[] args) {
		SpringApplication.run(BootRestApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();   
	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Hello World from command line runner");
//	}
}

