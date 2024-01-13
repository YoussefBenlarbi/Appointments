package com.example.appointmentmanagementmicroservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final int responceCode;
    private final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp,int responceCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        this.responceCode = responceCode;
    }



}
