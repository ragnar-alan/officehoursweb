package com.epam.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.epam"})
@PropertySource({"classpath:/hibernate.properties", "classpath:/application.properties"})
@EnableJpaRepositories("com.epam.**.repository")
@EntityScan("com.epam.**.domain")
public class MidMonthOfficehoursApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidMonthOfficehoursApplication.class, args);
    }
}
