package com.alex.repo.exception;

import com.alex.repo.constants.APIServiceError;
import com.alex.repo.exception.response.ApiError;
import com.alex.repo.exception.response.Severity;
import java.util.Collection;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class APIExcepiton extends RuntimeException {

    private Severity type;
    private String status;
    private String field;
    private String code;
    private String message;
    private HttpStatus httpStatus;
    private Collection<ApiError> errors;

    public APIExcepiton(Collection<ApiError> errors) {
        this.errors = errors;
    }

    public APIExcepiton(APIServiceError APIServiceError) {
        this.type = APIServiceError.getType();
        this.status = APIServiceError.getStatus();
        this.code = APIServiceError.name();
        this.message = APIServiceError.getMessage();
        this.httpStatus = APIServiceError.getHttpStatus();
    }

    public APIExcepiton(APIServiceError APIServiceError, String field) {
        this(APIServiceError);
        this.field = field;
    }
}
