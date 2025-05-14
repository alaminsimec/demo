package com.alamin.demo.core.services.log;

import com.alamin.demo.core.dto.log.MethodLogDTO;

import java.time.LocalDateTime;

public interface MethodLogService {
    void logMethodExecution(MethodLogDTO dto);
}
