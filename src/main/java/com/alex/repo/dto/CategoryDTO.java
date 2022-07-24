package com.alex.repo.dto;

import com.alex.repo.models.File;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDTO {
    private Long categoryId;
    private String name;
    private Set<File> files = new HashSet<>();
}
