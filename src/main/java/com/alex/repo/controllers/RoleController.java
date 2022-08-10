package com.alex.repo.controllers;

import com.alex.repo.dto.RoleDTO;
import com.alex.repo.mapper.RoleMapper;
import com.alex.repo.models.Role;
import com.alex.repo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = RoleController.BASE_URL)
public class RoleController {



    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/roles";

    @Autowired
    private RoleService roleService;
    @GetMapping
    public ResponseEntity<List<RoleDTO>> get() {
        List<Role> getRoleList = roleService.get();
        List<RoleDTO> responseList = RoleMapper.INSTANCE.roleToRoleDTOList(getRoleList);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
        //return roleService.get();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable Long id) {
        Role requestRole = roleService.getById(id);
        RoleDTO responseRole = RoleMapper.INSTANCE.roleToRoleDTO(requestRole);
        return new ResponseEntity<>(responseRole,HttpStatus.OK);
        //return roleService.getById(id);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO) {
        Role requestRole = RoleMapper.INSTANCE.roleDTOToRole(roleDTO);
        Role createRole = roleService.create(requestRole);
        RoleDTO responseRole = RoleMapper.INSTANCE.roleToRoleDTO(createRole);
        return new ResponseEntity<>(responseRole, HttpStatus.CREATED);
        //return roleService.create(role);
    }

    @PutMapping
    public ResponseEntity<RoleDTO> update(@Valid @RequestBody RoleDTO roleDTO) {
        Role requestRole = RoleMapper.INSTANCE.roleDTOToRole(roleDTO);
        Role updateRole = roleService.create(requestRole);
        RoleDTO responseRole = RoleMapper.INSTANCE.roleToRoleDTO(updateRole);
        return new ResponseEntity<>(responseRole, HttpStatus.OK);
        //return roleService.update(role);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
