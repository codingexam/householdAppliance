package com.appliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
//@EnableJpaRepositories(basePackages = "package com.appliance.repository")
public class HouseholdApplicanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseholdApplicanceApplication.class, args);
	}

}
