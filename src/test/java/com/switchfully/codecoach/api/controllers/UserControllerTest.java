package com.switchfully.codecoach.api.controllers;

import com.switchfully.codecoach.api.dtos.users.CreateUserDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.api.mappers.UserMapper;
import com.switchfully.codecoach.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
//
//    @Test
//    void testCreateUser(){
//        CreateUserDTO userDTO = new CreateUserDTO()
//                .setFirstName("Bob")
//                .setLastName("Bobbykins")
//                .setEmail("bob@bobby.com")
//                .setPassword("12345678A")
//                .setPictureUrl("https://www.1designshop.com/wp-content/uploads/2019/02/1designshop-2019-02-ppl001.png");
//
//        ResponseEntity<UserDTO> responseEntity = this.testRestTemplate.postForEntity("http://localhost:" + port + "/users", userDTO, UserDTO.class);
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertNotEquals(responseEntity.getBody(), null);
//        assertEquals(responseEntity.getBody().getFirstName(), userMapper.mapCreateUserDtoToUser(userDTO).getFirstName());
//
//    }
//
//    @Test
//    void testCreateUser_whenGivenBadInput_thenReturnBadRequest(){
//        CreateUserDTO userDTO = new CreateUserDTO()
//                .setFirstName("")
//                .setLastName("Bobbykins")
//                .setEmail("bob@bobbers.com")
//                .setPassword("12345678A")
//                .setPictureUrl("https://www.1designshop.com/wp-content/uploads/2019/02/1designshop-2019-02-ppl001.png");
//
//        ResponseEntity<UserDTO> responseEntity = this.testRestTemplate.postForEntity("http://localhost:" + port + "/users", userDTO, UserDTO.class);
//
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//
//    }

}
