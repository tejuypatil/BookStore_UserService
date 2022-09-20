package com.development.bookstore_userservice.exception;

public class UserOrPasswordWrong extends RuntimeException{
    public UserOrPasswordWrong(String loginId) {
        super("Login id or password is wrong. Given "+loginId+" as login id");
    }
}
