package com.switchfully.codecoach.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping(produces = "application/json")
    public String helloWorld() {
        return "Hello world!!!!!";
    }
}
