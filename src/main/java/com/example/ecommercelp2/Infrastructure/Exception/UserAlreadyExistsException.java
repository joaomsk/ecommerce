package com.example.ecommercelp2.Infrastructure.Exception;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

}
