package com.switchfully.codecoach.infrastructure.exceptions;

public class CoachSessionNotFoundException extends RuntimeException{
    public CoachSessionNotFoundException(String element) {
        super("Coach Session with " + element + " does not exist.");
    }
}

