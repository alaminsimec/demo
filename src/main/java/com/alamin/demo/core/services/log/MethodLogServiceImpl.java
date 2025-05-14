package com.alamin.demo.core.services.log;

import com.alamin.demo.core.dto.log.MethodLogDTO;
import com.alamin.demo.data.log.MethodLogEntry;
import com.alamin.demo.data.repositories.log.MethodLogRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MethodLogServiceImpl implements MethodLogService {
    private final MethodLogRepository methodLogRepository;

    public MethodLogServiceImpl(MethodLogRepository methodLogRepository) {
        this.methodLogRepository = methodLogRepository;
    }

    @Async("ioTaskExecutor")
    @Override
    public void logMethodExecution(MethodLogDTO dto) {
        MethodLogEntry logEntry = new MethodLogEntry();
        logEntry.setThreadName(dto.threadName());
        logEntry.setClassName(dto.className());
        logEntry.setMethodName(dto.methodName());
        logEntry.setExecutionTime(dto.executionTime());
        logEntry.setStatus(dto.status());
        logEntry.setStartTime(dto.startTime());
        logEntry.setEndTime(dto.endTime());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        methodLogRepository.save(logEntry);
    }
}
