package com.development.bookstore_userservice.dto;

import lombok.Data;

@Data
public class UserRegisterRequestDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String loginId;
    private String password;

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    private boolean isAdmin;

}