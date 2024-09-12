package com.example.awsproject.service.exception;

public class UserNotFoundException extends ApiExceptionService{
    public UserNotFoundException(String message) {
        super(message);
    }
}
