package com.alamin.demo.core.dto.log;

public record MethodLogDTO(
        String threadName, String className, String methodName,
        long executionTime, String status, long startTime, long endTime
) {
}
