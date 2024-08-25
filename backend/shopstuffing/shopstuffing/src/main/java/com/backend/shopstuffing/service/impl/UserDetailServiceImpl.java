package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.exception.ApplicationException;
import com.backend.shopstuffing.exception.UserErrorResponse;
import com.backend.shopstuffing.mapper.UserMapper;
import com.backend.shopstuffing.model.UserDetail;
import com.backend.shopstuffing.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;
    private final UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserMapper.toUserDetail(userRepository.findByUsername(username).orElseThrow(
                () -> new ApplicationException(UserErrorResponse.USER_NOT_EXISTED, HttpStatus.BAD_REQUEST)
        ));
    }

    public UserResponse signUpUser(UserCreateRequest request) {
        return userService.createUser(request);
    }
}
