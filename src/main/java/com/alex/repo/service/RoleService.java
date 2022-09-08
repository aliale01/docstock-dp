package com.alex.repo.service;

import com.alex.repo.dto.RoleDTO;
import com.alex.repo.models.Role;
import java.util.List;

public interface RoleService {

    List<Role> get();

    Role update(RoleDTO roleDTO);

    Role create(RoleDTO roleDTO);

    Role create(Role role);

    Role getById(String id);

    Role getRoleByName(String roleName);

    void delete(String id);

}
