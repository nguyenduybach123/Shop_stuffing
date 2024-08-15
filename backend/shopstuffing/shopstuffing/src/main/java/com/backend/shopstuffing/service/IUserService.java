package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.request.UserUpdateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;


import java.util.List;

public interface IUserService {
    UserResponse createUser(UserCreateRequest request);
    void deleteUser(String id);
    UserResponse updateUser(String id, UserUpdateRequest request);
    List<UserResponse> getAllUser();
    UserResponse getUser(String id);
    UserResponse getUserProfile();
}
