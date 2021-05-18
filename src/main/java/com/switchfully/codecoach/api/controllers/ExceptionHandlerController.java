package com.switchfully.codecoach.api.controllers;

import com.switchfully.codecoach.infrastructure.exceptions.AlreadyCoachException;
import com.switchfully.codecoach.infrastructure.exceptions.EmailAlreadyTakenException;
import com.switchfully.codecoach.infrastructure.exceptions.InvalidLogInDetailsException;
import com.switchfully.codecoach.infrastructure.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);


    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(),exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public void handleEmailAlreadyTakenException(EmailAlreadyTakenException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(),exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(AlreadyCoachException.class)
    public void handleAlreadyCoachException(AlreadyCoachException exception, HttpServletResponse response) throws  IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(InvalidLogInDetailsException.class)
    public void handleInvalidLoginDetailsException(InvalidLogInDetailsException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(),exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException(UserNotFoundException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(),exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST,exception.getMessage());
    }
}
