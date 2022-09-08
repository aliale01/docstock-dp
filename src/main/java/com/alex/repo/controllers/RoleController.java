package com.alex.repo.controllers;

import com.alex.repo.constants.UrlMapping;
import com.alex.repo.dto.RoleDTO;
import com.alex.repo.exception.response.ResponseHolder;
import com.alex.repo.mapper.RoleMapper;
import com.alex.repo.models.Role;
import com.alex.repo.service.RoleService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlMapping.ROLES)
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseHolder<List<RoleDTO>> get() {
        List<Role> getRoleList = roleService.get();
        List<RoleDTO> responseList = RoleMapper.INSTANCE.map(getRoleList);
        return new ResponseHolder<>(responseList);
        //return roleService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseHolder<RoleDTO> getById(@PathVariable String id) {
        Role requestRole = roleService.getById(id);
        RoleDTO responseRole = RoleMapper.INSTANCE.map(requestRole);
        return new ResponseHolder<>(responseRole);
        //return roleService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseHolder<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO) {
        Role createRole = roleService.create(roleDTO);
        RoleDTO responseRole = RoleMapper.INSTANCE.map(createRole);
        return new ResponseHolder<>(responseRole);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseHolder<RoleDTO> update(@Valid @RequestBody RoleDTO roleDTO) {
        Role updatedRole = roleService.update(roleDTO);
        RoleDTO roleToRoleDTO = RoleMapper.INSTANCE.map(updatedRole);
        return new ResponseHolder<>(roleToRoleDTO);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseHolder<String> delete(@PathVariable String id) {
        roleService.delete(id);
        return new ResponseHolder<>("OK");
    }
}
