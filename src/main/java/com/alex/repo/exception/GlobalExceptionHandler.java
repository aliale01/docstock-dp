package com.alex.repo.exception;

import static com.alex.repo.constants.HttpStatusConstant.CONFLICT;

import com.alex.repo.constants.APIServiceError;
import com.alex.repo.exception.response.ApiError;
import com.alex.repo.exception.response.ApiResponse;
import com.alex.repo.exception.response.Severity;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class})
@AllArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(APIExcepiton.class)
    @ResponseBody
    public ApiResponse processUserServiceException(HttpServletResponse response, APIExcepiton exception) {
        Collection<ApiError> errors = exception.getErrors();
        if (errors != null) {
            return buildUnsuccessfulResponse(errors);
        } else {
            response.setStatus(exception.getHttpStatus().value());
            exception.printStackTrace();
            ApiError apiError = getApiError(exception);
            return buildUnsuccessfulResponse(List.of(apiError));
        }
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ApiResponse uncheckedExceptionHandler(HttpServletResponse response, Throwable throwable) {
        response.setStatus(HttpStatus.CONFLICT.value());
        throwable.printStackTrace();
        ApiError apiError = getApiError(throwable);
        return buildUnsuccessfulResponse(List.of(apiError));
    }

    private static ApiResponse buildUnsuccessfulResponse(Collection<ApiError> errors) {
        return ApiResponse.builder()
                          .success(false)
                          .errors(errors)
                          .build();
    }

    private ApiError getApiError(APIExcepiton exception) {
        return ApiError.builder()
                       .type(exception.getType())
                       .code(exception.getCode())
                       .field(exception.getField())
                       .status(exception.getStatus())
                       .message(exception.getMessage())
                       .build();
    }

    private ApiError getApiError(Throwable throwable) {
        return ApiError.builder()
                       .type(Severity.FATAL)
                       .code(APIServiceError.UNHANDLED_ERROR.name())
                       .status(CONFLICT)
                       .message(throwable.getMessage())
                       .build();
    }
}
