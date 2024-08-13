package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.response.UserResponse;

public interface IUserService {
    UserResponse createUser(UserCreateRequest request);
}
