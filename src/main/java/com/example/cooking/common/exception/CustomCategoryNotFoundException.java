package com.example.cooking.common.exception;

public class CustomCategoryNotFoundException extends RuntimeException{

    public CustomCategoryNotFoundException(String message){
        super(message);
    }
}
