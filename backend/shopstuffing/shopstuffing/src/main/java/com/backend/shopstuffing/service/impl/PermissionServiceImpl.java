package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.PermissionRequest;
import com.backend.shopstuffing.dto.response.PermissionResponse;
import com.backend.shopstuffing.mapper.PermissionMapper;
import com.backend.shopstuffing.model.Permission;
import com.backend.shopstuffing.repository.IPermissionRepository;
import com.backend.shopstuffing.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public PermissionResponse createPermission(PermissionRequest request) {
        Permission permission = PermissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return PermissionMapper.toPermissionResponse(permission);
    }

    @Override
    public void deletePermission(String name) {
        permissionRepository.deleteByName(name);
    }

    @Override
    public List<PermissionResponse> getAllPermission() {
        return permissionRepository.findAll().stream().map(PermissionMapper::toPermissionResponse).toList();
    }
}
