package com.danielev86.customermicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.danielev86"})
public class SakilaCustomerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaCustomerMicroserviceApplication.class, args);
	}

}
