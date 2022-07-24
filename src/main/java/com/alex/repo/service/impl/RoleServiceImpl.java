package com.alex.repo.service.impl;

import com.alex.repo.models.Role;
import com.alex.repo.repositories.RoleRepository;
import com.alex.repo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> get() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getById(Long id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
