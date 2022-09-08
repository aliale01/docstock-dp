package com.alex.repo.dto;

import lombok.Data;

@Data
public class CustomDocumentDTO {

    private String id;// ?
    private String originalFileName;
    private String convertedFileName;
    private String description;
    private String fileType;
    private String path;
}
