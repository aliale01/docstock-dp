package com.alex.repo.dto;

import com.alex.repo.models.User;
import lombok.Data;


@Data
public class RoleDTO {

    private Long roleId;
    private String name;
    private String description;
    private User user;
}
