package com.alex.repo.controllers;

import com.alex.repo.constants.APIServiceError;
import com.alex.repo.constants.UrlMapping;
import com.alex.repo.dto.AuthResponse;
import com.alex.repo.dto.RefreshTokenRequest;
import com.alex.repo.dto.UserDTO;
import com.alex.repo.exception.APIExcepiton;
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

import java.sql.Date;
import java.time.Instant;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    private final RefreshTokenService refreshTokenService;

    @PostMapping(UrlMapping.REGISTER)
    public ResponseHolder<String> registerUser(@RequestBody UserDTO userDTO) {
            if (userDTO.getPassword().length() < 8 || userDTO.getPassword().length() > 255){
                throw new APIExcepiton(APIServiceError.INVALID_PASSWORD_LENGTH);
        }
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
                                                .username(userDTO.getUsername())
                                                .accessToken(token)
                                                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                                                .expiresAt(Date.from(Instant.now().plusMillis(jwtTokenUtil.getTokenExpirationMsec())).toInstant())
                                                .build());
    }

    @PostMapping(UrlMapping.REFRESH)
    public ResponseHolder<AuthResponse> refreshToken(
            @Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtTokenUtil.createTokenWithUsername(refreshTokenRequest.getUsername());
        return new ResponseHolder<>(AuthResponse.builder()
                                                .accessToken(token)
                                                .refreshToken(refreshTokenRequest.getRefreshToken())
                                                .build());
    }

    @PostMapping(UrlMapping.LOGOUT)
    public ResponseHolder<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return new ResponseHolder<>("User logged out successfully");
    }
}
