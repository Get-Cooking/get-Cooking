package com.example.cooking.common.exception;

public class ExceptionUnauthorized extends RuntimeException{

    public ExceptionUnauthorized (String message){
        super(message);
    }
}
