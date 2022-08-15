package com.alex.repo.controllers;

import com.alex.repo.dto.UserDTO;
import com.alex.repo.mapper.UserMapper;
import com.alex.repo.models.User;
import com.alex.repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> get() {
        List<User> getUserList = userService.get();
        List<UserDTO> responseList = UserMapper.INSTANCE.userToUserDTOList(getUserList);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User getUser = userService.getById(id);
        UserDTO responseUser = UserMapper.INSTANCE.userToUserDTO(getUser);
        return new ResponseEntity<>(responseUser,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        User requestUser = UserMapper.INSTANCE.userDTOToUser(userDTO);
        User createUser = userService.create(requestUser);
        UserDTO responseUser = UserMapper.INSTANCE.userToUserDTO(createUser);
        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO userDTO) {
        User requestUser = UserMapper.INSTANCE.userDTOToUser(userDTO);
        User updateUser = userService.create(requestUser);
        UserDTO responseUser = UserMapper.INSTANCE.userToUserDTO(updateUser);
        return new ResponseEntity<>(responseUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
