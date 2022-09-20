package com.development.bookstore_userservice.dto;

public class ExceptionResponse {
    public String errorMessage;

    public ExceptionResponse(String message) {
        this.errorMessage = message;
    }
}
