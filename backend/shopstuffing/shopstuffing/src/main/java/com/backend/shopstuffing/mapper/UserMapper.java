package com.backend.shopstuffing.mapper;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.model.User;

public class UserMapper {
    public static User toUser(UserCreateRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .birth(request.getBirth())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .build();
    }
}
