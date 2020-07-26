package com.edcoder1.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
//@RestController
public class SampleApp {

//	CONFLICTS WITH BUILDING PROCESS

//	public static void main(String[] args) {
//		SpringApplication.run(SampleApp.class, args);
//	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello-000 %s!", name);

	}

}
