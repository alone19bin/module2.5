package com.example.awsproject.service.exception;
public class ApiExceptionService extends RuntimeException{
    public ApiExceptionService(String message) {
        super(message);

    }
}
