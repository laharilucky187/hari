package com.demo.bankapp.error;

public enum ApiErrorMessage {
    GENERIC_ERROR("Error occurred"),
    UNKNOWN_ERROR("Unknown error occurred"),
    VALIDATION_ERROR("Validation error"),
    NOT_FOUND_ERROR("Not found error"),

    /* Authorization exceptions 40100 - 40120  */
    AUTHORIZATION_ERROR("Authorization error"),
    BAD_CREDENTIALS_ERROR("Bad credentials"),

    TOKEN_EXPIRED_ERROR("Token expired"),
    INVALID_TOKEN_ERROR("Invalid token"),
    TOKEN_CREATION_ERROR("Error when creating token");

    private String message;

    ApiErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}