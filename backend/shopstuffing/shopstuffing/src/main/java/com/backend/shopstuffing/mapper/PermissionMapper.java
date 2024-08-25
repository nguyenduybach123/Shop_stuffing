package com.backend.shopstuffing.mapper;

import com.backend.shopstuffing.dto.request.PermissionRequest;
import com.backend.shopstuffing.dto.response.PermissionResponse;
import com.backend.shopstuffing.model.Permission;

public class PermissionMapper {
    public static Permission toPermission(PermissionRequest request) {
        return Permission.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public static PermissionResponse toPermissionResponse(Permission permission){
        return PermissionResponse.builder()
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }
}
