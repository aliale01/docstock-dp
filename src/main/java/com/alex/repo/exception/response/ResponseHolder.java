package com.alex.repo.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHolder<T> extends ApiResponse {

    private T data;

    public ResponseHolder(T data) {
        this.data = data;
        setSuccess(true);
    }

    public T getData() {
        return data;
    }

    public ResponseHolder<T> setData(T response) {
        this.data = response;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResponseHolder [");
        if (data != null) {
            builder.append("response=");
            builder.append(data);
        }
        builder.append("] -> ").append(super.toString());
        return builder.toString();
    }
}
