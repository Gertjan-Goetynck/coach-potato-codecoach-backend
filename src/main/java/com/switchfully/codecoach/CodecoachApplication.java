package com.switchfully.codecoach;

import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CodecoachApplication {

	private static  UserService userService;
	@Autowired
	public CodecoachApplication(UserService userService) {
		CodecoachApplication.userService = userService;
	}


	public static void main(String[] args) {
		SpringApplication.run(CodecoachApplication.class, args);
		User user = new User("jos","peters","jos@peters.be","123");
		userService.addUser(user);

	}

}
