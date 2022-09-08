package com.alex.repo.controllers;

import com.alex.repo.constants.UrlMapping;
import com.alex.repo.dto.AuthResponse;
import com.alex.repo.dto.RefreshTokenRequest;
import com.alex.repo.dto.UserDTO;
import com.alex.repo.exception.response.ResponseHolder;
import com.alex.repo.security.JwtTokenUtil;
import com.alex.repo.service.AuthenticationService;
import com.alex.repo.service.RefreshTokenService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Borozdykh
 */

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    private final RefreshTokenService refreshTokenService;

    @PostMapping(UrlMapping.REGISTER)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseHolder<String> registerUser(@RequestBody UserDTO userDTO) {
        authenticationService.register(userDTO.getUsername(), userDTO.getPassword());
        return new ResponseHolder<>("User has created successfully");
    }

    @PostMapping(UrlMapping.LOGIN)
    public ResponseHolder<AuthResponse> login(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.createToken(authentication);
        return new ResponseHolder<>(AuthResponse.builder()
                                                .accessToken(token)
                                                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                                                .build());
    }

    @PostMapping(UrlMapping.REFRESH)
    public ResponseHolder<AuthResponse> refreshToken(
            @Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtTokenUtil.createTokenWithEmail(refreshTokenRequest.getUsername());
        return new ResponseHolder<>(AuthResponse.builder()
                                                .accessToken(token)
                                                .refreshToken(refreshTokenRequest.getRefreshToken())
                                                .build());
    }
}
