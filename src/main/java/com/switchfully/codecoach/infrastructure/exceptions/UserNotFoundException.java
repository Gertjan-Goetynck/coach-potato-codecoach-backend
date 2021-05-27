package com.switchfully.codecoach.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String element) {  super("User with " + element + " does not exist." );
    }
}
