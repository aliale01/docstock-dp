package com.alex.repo.exception.response;

import com.alex.repo.constants.APIServiceError;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError implements Serializable {

    private Severity type;
    private String code;
    private String field;
    private String status;
    private String message;
    private String length;
    private APIServiceError userServiceError;
}
