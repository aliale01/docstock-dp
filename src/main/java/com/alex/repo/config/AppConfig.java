package com.alex.repo.config;

import com.alex.repo.constants.UserRoleName;
import com.alex.repo.models.Role;
import com.alex.repo.models.User;
import com.alex.repo.service.RoleService;
import com.alex.repo.service.UserService;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Andrii Borozdykh
 */

@Configuration
@AllArgsConstructor
public class AppConfig {
    private static final String ADMIN = "admin";
    private static final String PASSWORD = "password";

    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        createRolesIfAbsent();
        createAdminUser();
    }

    private void createAdminUser() {
        User user = userService.findByUserName(ADMIN);
        if (user == null) {
            User admin = User.builder()
                             .username(ADMIN)
                             .password(passwordEncoder.encode(PASSWORD))
                             .build();
            Role adminRole = roleService.getRoleByName(UserRoleName.ADMIN.name());
            admin.addRole(adminRole);
            userService.create(admin);
        }
    }

    private void createRolesIfAbsent() {
        for (UserRoleName userRoleName : UserRoleName.values()) {
            String roleName = userRoleName.name();
            if (roleService.getRoleByName(roleName) == null) {
                roleService.create(Role.builder()
                                       .roleName(roleName)
                                       .description("Automatically created role " + roleName)
                                       .build());
            }
        }
    }
}
