package com.alex.repo.security;

import com.alex.repo.models.Role;
import com.alex.repo.models.User;
import com.alex.repo.service.UserService;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserService userService;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUserName(username);
        UserBuilder builder;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            Set<Role> roleSet = user.getRoles();
            String[] roles = roleSet.stream()
                                    .map(Role::getRoleName)
                                    .toArray(String[]::new);
            builder.roles(roles);
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
