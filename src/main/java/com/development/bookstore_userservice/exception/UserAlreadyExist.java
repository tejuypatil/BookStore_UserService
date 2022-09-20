package com.development.bookstore_userservice.exception;

import com.development.bookstore_userservice.dto.UserRegisterRequestDTO;

public class UserAlreadyExist extends RuntimeException{
        public UserAlreadyExist(UserRegisterRequestDTO userRegisterRequestDTO)
        {
            super("User "+userRegisterRequestDTO.getEmail()+" already exists");
        }
}

