package com.alex.repo.constants;

import org.springframework.http.HttpStatus;

public interface HttpStatusConstant {
    String BAD_REQUEST = String.valueOf(HttpStatus.BAD_REQUEST.value());
    String CONFLICT = String.valueOf(HttpStatus.CONFLICT.value());
    String UNAUTHORIZED = String.valueOf(HttpStatus.UNAUTHORIZED.value());
}
