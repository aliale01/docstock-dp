package com.alex.repo.service;

import com.alex.repo.models.User;

/**
 * @author Andrii Borozdykh
 */


public interface AuthenticationService {
    User register(String userName, String password);
}
