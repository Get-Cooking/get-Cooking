package com.example.cooking.common.exception;

public class SmsAlreadySentException extends RuntimeException{
    public SmsAlreadySentException(String message) {
        super(message);
    }
}
