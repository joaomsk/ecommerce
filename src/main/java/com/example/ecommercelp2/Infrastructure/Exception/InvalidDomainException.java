package com.example.ecommercelp2.Infrastructure.Exception;

import java.util.Set;

public class InvalidDomainException extends BusinessException {

    public InvalidDomainException(Set<String> messages) {
        super(messages.toString());
    }

    public InvalidDomainException(String message) {
        super(message);
    }
}
