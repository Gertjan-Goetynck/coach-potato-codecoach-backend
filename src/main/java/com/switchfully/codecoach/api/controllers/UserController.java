package com.switchfully.codecoach.api.controllers;


import com.switchfully.codecoach.api.dtos.users.CreateUserDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.api.mappers.UserMapper;
import com.switchfully.codecoach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins =  "http://localhost:4200")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody CreateUserDTO createUserDTO) {
        logger.info("New User passed  in controller");
        return userMapper.mapUserToDto(userService.addUser(userMapper.mapCreateUserDtoToUser(createUserDTO)));
    }

    @PutMapping(path="/coach/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO makeCoach(@PathVariable String userId){
        logger.info("Make user a coach");
        return userMapper.mapUserToDto(userService.makeCoach(userService.getUserById(userId)));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable String id){
        logger.info("Getting User by ID " + id);
        return userMapper.mapUserToDto(userService.getUserById(id));
    }
}
