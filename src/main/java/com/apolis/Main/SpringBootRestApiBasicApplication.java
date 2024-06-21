package com.apolis.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ComponentScan("com.apolis")
@SpringBootApplication
public class SpringBootRestApiBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiBasicApplication.class, args);
	}

}
