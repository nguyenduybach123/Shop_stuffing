package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.request.UserUpdateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.enums.Role;
import com.backend.shopstuffing.exception.ApplicationException;
import com.backend.shopstuffing.exception.UserErrorResponse;
import com.backend.shopstuffing.mapper.UserMapper;
import com.backend.shopstuffing.model.User;
import com.backend.shopstuffing.repository.IUserRepository;
import com.backend.shopstuffing.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        if(userRepository.existsUserByUsername(request.getUsername())) {
            throw new ApplicationException(UserErrorResponse.USER_EXISTED, HttpStatus.BAD_REQUEST);
        }

        User user = UserMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);

        userRepository.save(user);
        return UserMapper.toUserResponse(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public void deleteUser(String id) {
        if(!userRepository.existsUserById(id)) {
            throw new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST);
        }

        userRepository.deleteById(id);
    }

    @PostAuthorize("returnObject.username == authentication.name")
    @Override
    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST));

        UserMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return UserMapper.toUserResponse(userRepository.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream().map(UserMapper::toUserResponse).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public UserResponse getUser(String id) {
        return UserMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST)));
    }

    @Override
    public UserResponse getUserProfile() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST));

        return UserMapper.toUserResponse(user);
    }


}
