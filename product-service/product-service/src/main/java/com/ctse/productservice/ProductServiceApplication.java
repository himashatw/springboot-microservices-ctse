package com.ctse.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		System.out.println("Product Service Application Started");
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
