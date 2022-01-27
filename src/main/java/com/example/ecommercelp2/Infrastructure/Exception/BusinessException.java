package com.example.ecommercelp2.Infrastructure.Exception;

public abstract class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
