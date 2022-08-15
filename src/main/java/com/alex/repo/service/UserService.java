package com.alex.repo.service;


import com.alex.repo.models.User;

import java.util.List;

public interface UserService {

    List<User> get();

    User update(User user);

    User create(User user);

    User getById(Long id);

    void delete(Long id);

    void addRoleToUser(String username, String rolename);

}
