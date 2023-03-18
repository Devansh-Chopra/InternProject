package com.devansh.springboot.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorDetails {

    private LocalDateTime timeStamp;
    private List<String> validationErrors;

    private String details;

    public ValidationErrorDetails(LocalDateTime timeStamp, List<String> validationErrors, String details) {
        this.timeStamp = timeStamp;
        this.validationErrors = validationErrors;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }

    public String getDetails() {
        return details;
    }
}
