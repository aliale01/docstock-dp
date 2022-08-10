package com.alex.repo.dto;

import com.alex.repo.models.Role;
//import lombok.Data;

//@Data - Unsupported
public class UserDTO {

    private String username;
    private String password;
    private Role role;

    //GETTERS
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role  getRole() {
        return role;
    }

    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role  role) {
        this.role = role;
    }
}
