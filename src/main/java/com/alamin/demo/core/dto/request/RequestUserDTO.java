package com.alamin.demo.core.dto.request;

import com.alamin.demo.annotation.CustomEmptyValid;

public record RequestUserDTO(
        @CustomEmptyValid(message = "Username is not null or blank.")
        String username,
        @CustomEmptyValid(message = "Password is not null or blank.")
        String password,
        String email,
        String phone,
        String role
) {
}
