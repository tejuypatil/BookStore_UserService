package com.development.bookstore_userservice.dto;

import com.development.bookstore_userservice.entity.UserData;
import lombok.Data;

@Data
public class UserResponseDTO {
    private String message;
    private UserData userData;

    public UserResponseDTO(String message, UserData userData) {
        this.message = message;
        this.userData = userData;
        this.userData.setPassword("********************");
    }
}
