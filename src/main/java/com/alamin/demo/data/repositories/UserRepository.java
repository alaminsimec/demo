package com.alamin.demo.data.repositories;

import com.alamin.demo.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom {
    Optional<User> findByUsername(String username);
}
