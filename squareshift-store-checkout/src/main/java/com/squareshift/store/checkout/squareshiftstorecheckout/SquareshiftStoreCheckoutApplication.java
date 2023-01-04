package com.squareshift.store.checkout.squareshiftstorecheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;



@SpringBootApplication
@OpenAPIDefinition
public class SquareshiftStoreCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareshiftStoreCheckoutApplication.class, args);
	}

}
