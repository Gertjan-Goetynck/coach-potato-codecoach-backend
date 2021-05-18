package com.switchfully.codecoach.infrastructure.exceptions;

public class InvalidLogInDetailsException extends RuntimeException{

    public InvalidLogInDetailsException() {
        super("Invalid user log in details");
    }
}
