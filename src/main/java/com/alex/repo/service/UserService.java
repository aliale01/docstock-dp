package com.alex.repo.service;

import com.alex.repo.dto.UserDTO;
import com.alex.repo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User findByUserName(String username);

    User update(User user);

    User create(UserDTO userDTO);

    User create(User user);

    User getById(String id);

    void delete(String id);
    void addRoleToUser(String username, String role);
}
