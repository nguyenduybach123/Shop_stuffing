package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.enums.Role;
import com.backend.shopstuffing.mapper.UserMapper;
import com.backend.shopstuffing.model.User;
import com.backend.shopstuffing.repository.IUserRepository;
import com.backend.shopstuffing.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        if(userRepository.existsUserByUsername(request.getUsername())) {
            return null;
        }
        User user = UserMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);

        userRepository.save(user);
        return UserMapper.toUserResponse(user);
    }
}
