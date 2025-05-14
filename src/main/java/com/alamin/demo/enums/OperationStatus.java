package com.alamin.demo.enums;

public enum OperationStatus {
    SUCCESS(200, "The operation was successful and the resource was retrieved."),
    CREATED(201, "The resource has been successfully created."),
    UPDATED(200, "The resource was successfully updated."),
    DELETED(204, "The resource was successfully deleted. No content to return."),
    CONFLICT(409, "There was a conflict with the resource, typically due to conflicting data."),
    FAILURE(500, "The operation failed due to an unexpected error. Please try again later."),
    NOT_FOUND(404, "The resource was not found, it may have been removed or never existed."),
    VALIDATION_ERROR(422, "There was a validation error with the input data. Please check and try again.");

    private final int statusCode;
    private String statusMessage;

    OperationStatus(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
