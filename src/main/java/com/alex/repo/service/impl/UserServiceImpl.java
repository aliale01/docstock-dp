package com.alex.repo.service.impl;

import com.alex.repo.dto.UserDTO;
import com.alex.repo.mapper.UserMapper;
import com.alex.repo.models.User;
import com.alex.repo.repositories.UserRepository;
import com.alex.repo.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.map(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(String id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addRoleToUser(String username, String role) {

    }
}
