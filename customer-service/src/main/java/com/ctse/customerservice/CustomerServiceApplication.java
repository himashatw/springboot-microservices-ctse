package com.ctse.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class CustomerServiceApplication {

	public static void main(String[] args) {
		System.out.println("Customer Service Application Started");

		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
