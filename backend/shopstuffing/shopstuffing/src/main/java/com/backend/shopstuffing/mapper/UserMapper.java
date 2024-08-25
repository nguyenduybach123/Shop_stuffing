package com.backend.shopstuffing.mapper;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.request.UserUpdateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.model.User;
import com.backend.shopstuffing.model.UserDetail;

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

    public static UserDetail toUserDetail(User user) {
        return UserDetail.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }

    public static void updateUser(User user, UserUpdateRequest request) {
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstName());
        user.setLastname(request.getLastName());
        user.setBirth(request.getBirth());
    }
}
