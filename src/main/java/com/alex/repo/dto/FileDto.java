package com.alex.repo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.Data;

import java.time.LocalDateTime;

//@Data - Unsupported
public class FileDTO {

    private String name;
    private String path;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpload;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdate;

    //GETTERS
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateUpload() {
        return dateUpload;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateUpload(LocalDateTime dateUpload) {
        this.dateUpload = dateUpload;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
