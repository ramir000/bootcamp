package com.globant.bootcamp.controller.advice;


import com.globant.bootcamp.dao.exception.UserNotFoundException;
import com.globant.bootcamp.dao.exception.UserNullPointerException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<VndErrors> notFoundException(final UserNotFoundException e) {
        return ResponseEntity.notFound().build().ok(new VndErrors(e.getId().toString(), e.getMessage()));
    }

    @ExceptionHandler(UserNullPointerException.class)
    public ResponseEntity<VndErrors> notFoundException(final UserNullPointerException e) {
        return ResponseEntity.notFound().build().ok(new VndErrors("Error", e.getMessage()));
    }

  
}