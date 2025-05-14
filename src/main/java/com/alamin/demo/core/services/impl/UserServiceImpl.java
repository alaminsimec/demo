package com.alamin.demo.core.services.impl;

import com.alamin.demo.annotation.MethodLog;
import com.alamin.demo.core.dto.SuccessResponse;
import com.alamin.demo.core.dto.request.RequestUserDTO;
import com.alamin.demo.core.dto.response.ResponseUserDTO;
import com.alamin.demo.core.mapper.request.RequestUserMapper;
import com.alamin.demo.core.mapper.response.ResponseUserDtoMapper;
import com.alamin.demo.core.services.interfaces.UserService;
import com.alamin.demo.data.model.User;
import com.alamin.demo.data.repositories.UserRepository;
import com.alamin.demo.enums.OperationStatus;
import com.alamin.demo.enums.PredicateMode;
import com.alamin.demo.exception.handles.ConflictHandlerException;
import com.alamin.demo.exception.validators.RequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RequestValidator<RequestUserDTO> userDTORequestValidator;
    private final RequestUserMapper requestUserMapper;
    private final ResponseUserDtoMapper responseUserDtoMapper;




    @Override
    @MethodLog(clazzName = "UserServiceImpl")
    public SuccessResponse<?> save(RequestUserDTO dto) {
        SuccessResponse<ResponseUserDTO> response = new SuccessResponse<>();
        try {
            userDTORequestValidator.validate(dto);
            var userObj  = requestUserMapper.apply(dto);
            userRepository.findByUsername(userObj.getUsername().toUpperCase()).ifPresent(user -> {
                throw new ConflictHandlerException(String.format("Username %s already exists", user.getUsername()));
            });
            User save = userRepository.save(userObj);
            ResponseUserDTO apply = responseUserDtoMapper.apply(save);

            response.setData(apply);
            response.setStatusCode(OperationStatus.CREATED.getStatusCode());
            response.setStatusMessage(OperationStatus.CREATED.name());
            response.setMessage(OperationStatus.CREATED.getStatusMessage());
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SuccessResponse<?> searchUsers(String email, String role, String phone, PredicateMode mode) {
        SuccessResponse<List<ResponseUserDTO> > response = new SuccessResponse<>();
        List<ResponseUserDTO> list = userRepository.findByEmailAndRoleAndPhone(email, role, phone, mode).stream()
                .map(responseUserDtoMapper).toList();
        response.setData(list);
        response.setStatusCode(OperationStatus.SUCCESS.getStatusCode());
        response.setStatusMessage(OperationStatus.SUCCESS.name());
        response.setMessage(OperationStatus.SUCCESS.getStatusMessage());
        return response;
    }
}


