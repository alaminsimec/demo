package com.alamin.demo.data.repositories.log;

import com.alamin.demo.data.log.MethodLogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MethodLogRepository extends JpaRepository<MethodLogEntry, Long> {
}