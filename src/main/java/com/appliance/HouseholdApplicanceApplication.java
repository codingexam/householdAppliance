package com.appliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class HouseholdApplicanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseholdApplicanceApplication.class, args);
	}

}
