package com.alex.repo.service.impl;

import com.alex.repo.models.Role;
import com.alex.repo.models.User;
import com.alex.repo.service.AuthenticationService;
import com.alex.repo.service.RoleService;
import com.alex.repo.service.UserService;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserService userService;
    @Override
    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Role role = roleService.getRoleByName("USER");
        user.setRoles(Set.of(role));
        return userService.create(user);
    }
}
