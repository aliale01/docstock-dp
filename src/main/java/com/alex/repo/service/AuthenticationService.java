package com.alex.repo.service;

import com.alex.repo.models.User;

public interface AuthenticationService {
    User register(String userName, String password);
}
