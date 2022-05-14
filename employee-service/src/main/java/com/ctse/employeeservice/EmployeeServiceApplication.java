package com.ctse.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		System.out.println("Employee Service Application Started");

		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
