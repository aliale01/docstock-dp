package com.alex.repo.dto;

//import lombok.Data;

//@Data - Unsupported
public class CategoryDTO {
    private String name;

    //GETTERS
    public String getName() {
        return name;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
}
