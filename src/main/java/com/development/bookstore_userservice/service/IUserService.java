package com.development.bookstore_userservice.service;

import com.development.bookstore_userservice.dto.UserLoginRequestDTO;
import com.development.bookstore_userservice.dto.UserRegisterRequestDTO;
import com.development.bookstore_userservice.entity.UserData;

public interface IUserService {
    UserData registerUser(UserRegisterRequestDTO userRegisterRequestDTO);

    String login(UserLoginRequestDTO userLoginRequestDTO);

    UserData getUser(int userId);
}