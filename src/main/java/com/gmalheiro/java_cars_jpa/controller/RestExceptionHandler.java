package com.gmalheiro.java_cars_jpa.controller;

import com.gmalheiro.java_cars_jpa.exception.CarException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CarException.class)
    public ProblemDetail handleCarException (CarException e) {
        return e.toProblemDetail();
    }

}
