package com.alamin.demo.data.repositories;

import com.alamin.demo.data.model.User;
import com.alamin.demo.enums.PredicateMode;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByEmailAndRoleAndPhone(String email, String role, String phone, PredicateMode mode);

}
