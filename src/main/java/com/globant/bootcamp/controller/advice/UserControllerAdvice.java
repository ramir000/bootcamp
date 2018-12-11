package com.globant.bootcamp.controller.advice;

import java.util.Optional;

import javax.el.PropertyNotFoundException;

import com.globant.bootcamp.dao.exception.UserNotFoundException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<VndErrors> notFoundException(final UserNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
    }

    private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus,
            final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }
}