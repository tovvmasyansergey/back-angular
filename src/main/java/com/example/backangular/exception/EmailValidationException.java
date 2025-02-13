package com.example.backangular.exception;

public class EmailValidationException extends RuntimeException{
    public EmailValidationException(String message) {
        super(message);
    }
}
