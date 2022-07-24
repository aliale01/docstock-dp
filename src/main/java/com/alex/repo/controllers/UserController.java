package com.alex.repo.controllers;

import com.alex.repo.models.User;
import com.alex.repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/users";

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> get() {
        return userService.get();
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
