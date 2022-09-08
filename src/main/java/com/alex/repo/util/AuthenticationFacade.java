package com.alex.repo.util;

import com.alex.repo.models.User;
import com.alex.repo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationFacade {

    private final UserService userService;

    public String getUsername(){
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public User getUser(){
        return userService.findByUserName(getUsername());
    }
}
