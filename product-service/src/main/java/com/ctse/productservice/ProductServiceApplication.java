package com.ctse.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class ProductServiceApplication {

	public static void main(String[] args) {
		System.out.println("Product Service Application Started");
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
