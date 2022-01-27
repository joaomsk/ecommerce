package com.example.ecommercelp2.Infrastructure.Exception;

import java.util.Set;

public class DomainInvalidException extends BusinessException {

    public DomainInvalidException(Set<String> messages) {
        super(messages.toString());
    }

    public DomainInvalidException(String message) {
        super(message);
    }
}
