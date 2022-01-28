package com.example.ecommercelp2.Service.DTO;

public class ErrorDTO {
    private final String key;
    private final String message;

    public ErrorDTO(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
