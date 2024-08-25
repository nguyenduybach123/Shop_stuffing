package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.request.PermissionRequest;
import com.backend.shopstuffing.dto.response.PermissionResponse;

import java.util.List;

public interface IPermissionService {
    PermissionResponse createPermission(PermissionRequest request);
    void deletePermission(String name);
    List<PermissionResponse> getAllPermission();
}
