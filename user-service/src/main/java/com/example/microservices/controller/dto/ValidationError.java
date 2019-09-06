package com.example.microservices.controller.dto;

public class ValidationError {

    private String field;
    private String error;

    public ValidationError(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
