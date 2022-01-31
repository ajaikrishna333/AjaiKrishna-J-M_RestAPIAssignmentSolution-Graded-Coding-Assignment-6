package com.ajai.EmployeeDatabase.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig { 
	
	@Bean
	public Docket crmApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("EmployeeDatabase-Api")
				.select().apis(RequestHandlerSelectors.basePackage("com.ajai.EmployeeDatabase.Controller"))
				.build();		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee DB - Api")
				.description( "ADMINS CAN ACCESS THE BELOW FUNCTIONS"+ "\r\n" + "\r\n" +"/saveEmployee " + "\r\n" + "/deleteEmployeeById" + "\r\n" + "/updateEmployee"
						+ "\r\n"
						+ "\r\n"
						+"ADMINS AND USERS CAN ACCESS THE BELOW FUNCTIONS"
						+ "\r\n" + "/user " + "\r\n" + " /role " + "\r\n" + " /findEmployeeById " + "\r\n" + "/findEmployeeByFirstName " + "\r\n" + "/getAllEmployeesSortedByFirstName " + "\r\n" + " /findAllEmployee"
						+ "")
				.contact(new Contact("CRM-API", "http://fakelibrary.com","jmajaikrishna@gl.com"))
				.license("License")
				.licenseUrl("http://fakelibrary.com")
				.version("1.0")
				.build();
	}
	
}
