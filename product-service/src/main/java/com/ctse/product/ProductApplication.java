package com.ctse.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		System.out.println("Product Application Started");
		SpringApplication.run(ProductApplication.class, args);
	}

}
