package com.alex.repo.service.impl;

import com.alex.repo.dto.RoleDTO;
import com.alex.repo.mapper.RoleMapper;
import com.alex.repo.models.Role;
import com.alex.repo.repositories.RoleRepository;
import com.alex.repo.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> get() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(RoleDTO roleDTO) {
        Role role = RoleMapper.INSTANCE.map(roleDTO);
        return roleRepository.save(role);
    }

    @Override
    public Role create(RoleDTO roleDTO) {
        Role role = new Role(roleDTO);
        return this.create(role);
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getById(String id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }

    @Override
    public void delete(String id) {
        roleRepository.deleteById(id);
    }
}
