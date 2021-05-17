package com.switchfully.codecoach.infrastructure.exceptions;

public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException(String email) {
        super("Email " + email + " is already in use");
    }
}
