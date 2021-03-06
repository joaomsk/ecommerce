package com.example.ecommercelp2.Infrastructure.Exception;

import com.example.ecommercelp2.Service.DTO.ErrorDTO;

import java.time.LocalDateTime;
import java.util.Set;

public class ApiResponse {
    private final LocalDateTime timestamp;
    private final Integer status;
    private final String code;
    private final Set<ErrorDTO> errors;

    public ApiResponse(LocalDateTime timestamp, Integer status, String code, Set<ErrorDTO> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.code = code;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public Set<ErrorDTO> getErrors() {
        return errors;
    }
}
