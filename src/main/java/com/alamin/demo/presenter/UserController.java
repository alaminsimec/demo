package com.alamin.demo.presenter;

import com.alamin.demo.core.dto.request.RequestUserDTO;
import com.alamin.demo.core.services.interfaces.UserService;
import com.alamin.demo.enums.PredicateMode;
import com.alamin.demo.utils.url.UrlUserSupplier;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlUserSupplier.BASE_USER)
@RequiredArgsConstructor
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RequestUserDTO dto) {
        logger.info("Create user: {}", dto);
//        userService.save(dto);
        return new ResponseEntity<>(userService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping(UrlUserSupplier.SEARCH_USER)
    public ResponseEntity<?> searchUsers(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "AND") PredicateMode mode
    ) {
        logger.info("Search users: {}", email);
        logger.info("Search users: {}", role);
        logger.info("Search users: {}", phone);
        logger.info("Search users: {}", mode);
        return new ResponseEntity<>(userService.searchUsers(email, role, phone, mode), HttpStatus.OK);
    }

}
