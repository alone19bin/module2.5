package com.example.awsproject.service.exception;

public class NotFoundException extends ApiExceptionService{
    public NotFoundException(String message) {
        super(message);
    }
}
