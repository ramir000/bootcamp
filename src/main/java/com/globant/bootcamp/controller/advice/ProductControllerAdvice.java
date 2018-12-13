package com.globant.bootcamp.controller.advice;


import com.globant.bootcamp.dao.exception.ProductNotFoundException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> notFoundException(final ProductNotFoundException e) {
        return ResponseEntity.notFound().build().ok(new VndErrors(e.getId().toString(), e.getMessage()));
    }

}