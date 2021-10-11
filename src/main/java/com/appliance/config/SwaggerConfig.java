package com.appliance.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/*")).build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {

		return new ApiInfo("Appliance Microservice",
				"Appliance Microservice for household appliances portal provided by Coding Exam", 
				"1.0",
				"http://example.com", 
				new Contact("codingexam", "www.google.com", "123@gmail.com"),
				"Terms of Use License", 
				"https://github.com/codingexam/householdAppliance/blob/main/README.md",
				Collections.emptyList()

		);
	}

	/*
	 * @SuppressWarnings("deprecation") private ApiInfo apiDetails() { return new
	 * ApiInfo("Appliance Microservice", "Sample Appliance App for Coding exam",
	 * "1.0", "Free to use", new String("Learners"), "Sample License",
	 * "http://example.com"); }
	 */
}
