package com.development.bookstore_userservice.dto;

import lombok.Data;

@Data
public class UserLoginRequestDTO {
    private String loginId;
    private String password;
}