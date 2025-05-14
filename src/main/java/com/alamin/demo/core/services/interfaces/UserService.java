package com.alamin.demo.core.services.interfaces;

import com.alamin.demo.core.dto.SuccessResponse;
import com.alamin.demo.core.dto.request.RequestUserDTO;
import com.alamin.demo.enums.PredicateMode;

public interface UserService {
    SuccessResponse<?> save(RequestUserDTO dto);
    SuccessResponse<?> searchUsers(String email, String role, String phone, PredicateMode mode);
}
