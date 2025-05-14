package com.alamin.demo.core.mapper.request;

import com.alamin.demo.core.dto.request.RequestUserDTO;
import com.alamin.demo.data.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class RequestUserMapper implements Function<RequestUserDTO, User> {
    @Override
    public User apply(RequestUserDTO dto) {
        return dto == null ? null : User.builder()
                .username(dto.username().toUpperCase())
                .email(dto.email())
                .password(dto.password())
                .phone(dto.phone())
                .role(dto.role())
                .build();
    }
}
