package com.alamin.demo.core.dto;

import com.alamin.demo.utils.common.LocalDateFormatPattern;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorResponse<T>(
        int statusCode,
        String statusMessage,
        String message,
        T data,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateFormatPattern.pattern)
        LocalDateTime timestamp
) {}
