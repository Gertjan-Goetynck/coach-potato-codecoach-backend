package com.switchfully.codecoach.infrastructure.exceptions;

import com.switchfully.codecoach.domain.models.users.User;

public class AlreadyCoachException extends RuntimeException {

    private static final String ERROR_COACH_MESSAGE = "You are already a coach.";
    public AlreadyCoachException() {super(ERROR_COACH_MESSAGE);
    }
}
