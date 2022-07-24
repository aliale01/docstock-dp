package com.alex.repo.controllers;

import com.alex.repo.models.Role;
import com.alex.repo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Role> get() {
        return roleService.get();
    }

    @GetMapping(value = "/{id}")
    public Role getById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PostMapping
    public Role create(@Valid @RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping
    public Role update(@Valid @RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
