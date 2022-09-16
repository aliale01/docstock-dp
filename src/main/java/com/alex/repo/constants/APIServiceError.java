package com.alex.repo.constants;

import static com.alex.repo.constants.HttpStatusConstant.BAD_REQUEST;
import static com.alex.repo.constants.HttpStatusConstant.INTERNAL_SERVER_ERROR;
import static com.alex.repo.constants.HttpStatusConstant.UNAUTHORIZED;
import static com.alex.repo.exception.response.Severity.ERROR;

import com.alex.repo.exception.response.Severity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum APIServiceError {

    UNKNOWN_MIME_TYPE(ERROR, BAD_REQUEST, "Unknown mime type"),
    UNKNOWN_USER(ERROR, BAD_REQUEST, "Unknown user"),
    USER_UNAUTHORIZED(ERROR, UNAUTHORIZED, "Unauthorized"),
    USER_EXISTS(ERROR, BAD_REQUEST, "This user already exists"),
    INVALID_PASSWORD_LENGTH(ERROR, BAD_REQUEST, "Password should be more than 8 characters."),
    SERVER_ERROR(ERROR, INTERNAL_SERVER_ERROR, "Internal server error"),
    INVALID_REFRESH_TOKEN(ERROR, BAD_REQUEST, "Invalid refresh token"),
    DOCUMENT_NOT_FOUND(ERROR, BAD_REQUEST, "Document not found");

    private HttpStatus httpStatus;
    private String message;
    private String status;
    private Severity type;

    APIServiceError(Severity type, String status, String message) {
        this.httpStatus = HttpStatus.OK;
        this.type = type;
        this.status = status;
        this.message = message;
    }
}
