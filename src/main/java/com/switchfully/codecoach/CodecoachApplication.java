package com.switchfully.codecoach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CodecoachApplication {


	public static void main(String[] args) {
		SpringApplication.run(CodecoachApplication.class, args);
	}

}
