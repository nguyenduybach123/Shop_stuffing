package com.backend.shopstuffing.mapper;

import com.backend.shopstuffing.dto.request.RoleRequest;
import com.backend.shopstuffing.dto.response.RoleResponse;
import com.backend.shopstuffing.model.Role;

public class RoleMapper {
    public static Role toRole(RoleRequest request){
        return Role.builder()
                .name(request.getName())
                .description(request.getDescription())
                .permissions(request.getPermissions())
                .build();
    }

    public static RoleResponse toRoleResponse(Role role) {
        return RoleResponse.builder()
                .name(role.getName())
                .description(role.getDescription())
                .permissions(role.getPermissions())
                .build();
    }
}
