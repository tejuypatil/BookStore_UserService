package com.development.bookstore_userservice.controller;

import com.development.bookstore_userservice.dto.UserLoginRequestDTO;
import com.development.bookstore_userservice.dto.UserLoginResponseDTO;
import com.development.bookstore_userservice.dto.UserRegisterRequestDTO;
import com.development.bookstore_userservice.dto.UserRegisterResponseDTO;
import com.development.bookstore_userservice.entity.UserData;
import com.development.bookstore_userservice.service.UserService;
import com.development.bookstore_userservice.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataController {
    @Autowired
    public UserService userService;

    @Autowired
    TokenUtility tokenUtility;

    @PostMapping("/userservice/register")
    public ResponseEntity<UserRegisterResponseDTO> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        UserData userData=userService.registerUser(userRegisterRequestDTO);
        UserRegisterResponseDTO userRegisterResponseDTO=new UserRegisterResponseDTO(userData,"User registered successfully");
        return new ResponseEntity<UserRegisterResponseDTO>(userRegisterResponseDTO, HttpStatus.OK);
    }

    @PostMapping("userservice/login")
    public ResponseEntity<UserLoginResponseDTO> loginUser(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        String token = userService.login(userLoginRequestDTO);
        return new ResponseEntity<UserLoginResponseDTO>(new UserLoginResponseDTO("Token Generated",token),HttpStatus.OK);
    }
}

