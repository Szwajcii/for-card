package com.forcard.core.shared.exception;

public enum ErrorCode {

    ENTITY_NOT_FOUND("Entity not found.");

    private String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
