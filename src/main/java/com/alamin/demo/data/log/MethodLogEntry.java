package com.alamin.demo.data.log;

import com.alamin.demo.data.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity
@Table(name = "method_logs")
public class MethodLogEntry extends BaseEntityLog {
    private String threadName;
    private String className;
    private String methodName;
    private long executionTime;
}
