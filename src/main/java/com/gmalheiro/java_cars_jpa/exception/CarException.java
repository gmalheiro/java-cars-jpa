package com.gmalheiro.java_cars_jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarException extends RuntimeException{

    public ProblemDetail toProblemDetail () {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Car internal server error");

        return  pb;
    }

}
