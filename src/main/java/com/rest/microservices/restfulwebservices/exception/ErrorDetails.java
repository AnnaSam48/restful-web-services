package com.rest.microservices.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private ZonedDateTime timestamp;
    private String message;
    private String details;
}
