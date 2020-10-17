package com.demo.studentapirest;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.demo.studentapirest.controller", "com.demo.studentapirest.service", "com.demo.studentapirest.config"})
@EntityScan("com.demo.studentapirest.entity")
@EnableJpaRepositories("com.demo.studentapirest.repository")
public class StudentApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiRestApplication.class, args);
	}

}
