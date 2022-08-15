package com.alex.repo.dto;

import java.util.Collection;
//import lombok.Data;

//@Data - Unsupported
public class UserDTO {

    private String username;
    private String password;

    //GETTERS
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
