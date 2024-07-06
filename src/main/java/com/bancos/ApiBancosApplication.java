package com.bancos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API-Bancos",
			version = "1.0",
			description = "Documentando uma API para informações sobre bancos",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class ApiBancosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBancosApplication.class, args);
	}

}
