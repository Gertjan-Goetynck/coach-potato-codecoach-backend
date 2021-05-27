package com.switchfully.codecoach.infrastructure.exceptions;

public class AlreadyCoachException extends RuntimeException {

    private static final String ERROR_COACH_MESSAGE = "You are already a coach.";
    public AlreadyCoachException() {super(ERROR_COACH_MESSAGE);
    }
}
