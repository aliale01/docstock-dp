package com.alex.repo.constants;

import org.springframework.http.HttpStatus;

/**
 * @author Andrii Borozdykh
 */

public interface HttpStatusConstant {
    String BAD_REQUEST = String.valueOf(HttpStatus.BAD_REQUEST.value());
    String INTERNAL_SERVER_ERROR = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
    String UNAUTHORIZED = String.valueOf(HttpStatus.UNAUTHORIZED.value());
}
