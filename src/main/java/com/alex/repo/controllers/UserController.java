package com.alex.repo.controllers;

import com.alex.repo.constants.UrlMapping;
import com.alex.repo.dto.UserDTO;
import com.alex.repo.exception.response.ResponseHolder;
import com.alex.repo.mapper.UserMapper;
import com.alex.repo.models.User;
import com.alex.repo.service.UserService;
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
@RequestMapping(UrlMapping.USERS)
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    public ResponseHolder<List<UserDTO>> get() {
        List<User> getUserList = userService.getAllUsers();
        List<UserDTO> responseList = UserMapper.INSTANCE.map(getUserList);
        return new ResponseHolder<>(responseList);
    }

    @GetMapping(value = "/{id}")
    public ResponseHolder<UserDTO> getById(@PathVariable String id) {
        User user = userService.getById(id);
        UserDTO userDTO = UserMapper.INSTANCE.map(user);
        return new ResponseHolder<>(userDTO);
    }

    @PostMapping
    public ResponseHolder<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.create(userDTO);
        UserDTO responseUserDTO = UserMapper.INSTANCE.map(user);
        return new ResponseHolder<>(responseUserDTO);
    }

    @PutMapping
    public ResponseHolder<UserDTO> update(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.create(userDTO);
        UserDTO responseUserDTO = UserMapper.INSTANCE.map(user);
        return new ResponseHolder<>(responseUserDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseHolder<String> delete(@PathVariable String id) {
        userService.delete(id);
        return new ResponseHolder<>("OK");
    }
}
