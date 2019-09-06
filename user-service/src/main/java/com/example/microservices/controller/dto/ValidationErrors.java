package com.example.microservices.controller.dto;

import java.util.List;

public class ValidationErrors {

    private List<ValidationError> errors;

    public ValidationErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
