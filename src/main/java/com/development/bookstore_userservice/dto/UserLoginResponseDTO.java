package com.development.bookstore_userservice.dto;

public class UserLoginResponseDTO {
    public String message;
    public String token;

    public UserLoginResponseDTO(String message,String token) {
        this.message = message;
        this.token = token;
    }
}
