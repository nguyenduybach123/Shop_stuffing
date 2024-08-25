package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.request.RoleRequest;
import com.backend.shopstuffing.dto.response.RoleResponse;

import java.util.List;

public interface IRoleService {
    RoleResponse createRole(RoleRequest request);
    void deleteRole(String name);
    List<RoleResponse> getAllRole();
}
