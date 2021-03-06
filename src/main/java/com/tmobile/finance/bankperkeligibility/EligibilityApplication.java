package com.tmobile.finance.bankperkeligibility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
public class EligibilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(EligibilityApplication.class, args);
	}
	
	
	
}
