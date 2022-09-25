package com.development.bookstore_userservice.controller;

import com.development.bookstore_userservice.dto.*;
import com.development.bookstore_userservice.entity.UserData;
import com.development.bookstore_userservice.service.UserService;
import com.development.bookstore_userservice.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("userservice/{userId}")
    public ResponseEntity<UserResponseDTO> getBookById(@PathVariable("userId") int userId){
       UserData userData=userService.getUser(userId);
        return new ResponseEntity<UserResponseDTO>(new UserResponseDTO("Get call for Id successful",userData),HttpStatus.OK);

    }
}

