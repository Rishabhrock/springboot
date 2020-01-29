package com.rishabh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.rishabh.springboot.databasecontroller"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringbootApplication
{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}



