package com.alex.repo.dto;

import com.alex.repo.models.File;
import com.alex.repo.models.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private Long userId;
    private String username;
    private String password;

    private Role role;

    private Set<File> files;
}
