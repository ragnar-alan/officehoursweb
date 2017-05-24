package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.epam")
public class MidMonthOfficehoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidMonthOfficehoursApplication.class, args);
	}
}
