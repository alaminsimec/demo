package com.alamin.demo.core.dto.response;

import java.time.LocalDateTime;

public record ResponseUserDTO(
        Long id,
        String username,
        String email,
        String phone,
        String role,
        LocalDateTime createdTime,
        LocalDateTime updatedTime,
        String createdBy,
        String updatedBy
) {
}
