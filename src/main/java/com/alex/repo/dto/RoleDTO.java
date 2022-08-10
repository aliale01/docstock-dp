package com.alex.repo.dto;

//import lombok.Data;

//@Data - Unsuported
public class RoleDTO {

    private String name;
    private String description;

    //GETTERS
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
