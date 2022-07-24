package com.alex.repo.service;

import com.alex.repo.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> get();

    Role update(Role role);

    Role create(Role role);

    Role getById(Long id);

    void delete(Long id);

}
