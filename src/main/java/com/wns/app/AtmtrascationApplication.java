package com.wns.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.wns")
public class AtmtrascationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmtrascationApplication.class, args);
	}
}
