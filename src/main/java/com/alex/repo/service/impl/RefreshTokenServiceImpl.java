package com.alex.repo.service.impl;

import com.alex.repo.constants.APIServiceError;
import com.alex.repo.exception.APIExcepiton;
import com.alex.repo.models.RefreshToken;
import com.alex.repo.repositories.RefreshTokenRepository;
import com.alex.repo.service.RefreshTokenService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public RefreshToken generateRefreshToken() {
        logger.info("Generating new refresh token");
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    public void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token).orElseThrow(
                () -> new APIExcepiton(APIServiceError.SERVER_ERROR));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
