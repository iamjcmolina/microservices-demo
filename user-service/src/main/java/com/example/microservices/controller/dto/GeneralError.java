package com.example.microservices.controller.dto;

public class GeneralError {

    private String message;

    public GeneralError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
