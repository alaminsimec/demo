package com.alamin.demo.core.mapper.response;

import com.alamin.demo.core.dto.response.ResponseUserDTO;
import com.alamin.demo.data.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResponseUserDtoMapper implements Function<User, ResponseUserDTO> {
    @Override
    public ResponseUserDTO apply(User user) {
        return user == null ? null :
                new ResponseUserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getRole(),
                        user.getCreatedTime(), user.getUpdatedTime(), user.getCreatedBy(), user.getUpdatedBy());
    }
}
