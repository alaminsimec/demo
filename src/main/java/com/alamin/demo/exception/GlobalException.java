package com.alamin.demo.exception;

import com.alamin.demo.core.dto.ErrorResponse;
import com.alamin.demo.enums.OperationStatus;
import com.alamin.demo.exception.handler.ConflictHandlerException;
import com.alamin.demo.exception.validators.RequestValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler(RequestValidatorException.class)
    public ResponseEntity<?> handleDataValidationException(RequestValidatorException errors) {
        ErrorResponse<Map<String, String>> errorResponse = new ErrorResponse<>(
                OperationStatus.VALIDATION_ERROR.getStatusCode(),
                OperationStatus.VALIDATION_ERROR.name(),
                OperationStatus.VALIDATION_ERROR.getStatusMessage(),
                errors.getErrors(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(ConflictHandlerException.class)
    public ResponseEntity<?> handleConflictHandlerException(ConflictHandlerException errors) {

        var conflict = OperationStatus.CONFLICT;
        conflict.setStatusMessage(errors.getMessage() == null || errors.getMessage().isBlank() ? conflict.getStatusMessage() : errors.getMessage());
        ErrorResponse<String> response = new ErrorResponse<>(
                conflict.getStatusCode(),
                conflict.name(),
                conflict.getStatusMessage(),
                errors.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
