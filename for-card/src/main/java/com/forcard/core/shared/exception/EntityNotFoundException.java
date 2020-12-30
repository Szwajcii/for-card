package com.forcard.core.shared.exception;

import java.util.UUID;

import static com.forcard.core.shared.exception.ErrorCode.ENTITY_NOT_FOUND;

public class EntityNotFoundException extends RuntimeException {

    private UUID errorId;
    private ErrorCode errorCode;

    public EntityNotFoundException(String message) {
        this(message, UUID.randomUUID(), ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(String message, UUID errorId, ErrorCode errorCode) {
        super(message);
        this.errorId = errorId;
        this.errorCode = errorCode;
    }
}
