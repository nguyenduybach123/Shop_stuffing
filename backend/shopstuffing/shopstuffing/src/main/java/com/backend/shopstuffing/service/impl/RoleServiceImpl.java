package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.RoleRequest;
import com.backend.shopstuffing.dto.response.PermissionResponse;
import com.backend.shopstuffing.dto.response.RoleResponse;
import com.backend.shopstuffing.mapper.RoleMapper;
import com.backend.shopstuffing.model.Role;
import com.backend.shopstuffing.repository.IPermissionRepository;
import com.backend.shopstuffing.repository.IRoleRepository;
import com.backend.shopstuffing.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IPermissionRepository permissionRepository;
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public RoleResponse createRole(RoleRequest request) {
        Role role = RoleMapper.toRole(request);

        var permissions = permissionRepository.findAllByName(role.getPermissions()).stream().map((permission -> permission.getName())).toList();
        role.setPermissions(new HashSet<>(permissions));

        return RoleMapper.toRoleResponse(role);
    }

    @Override
    public void deleteRole(String name) {
        roleRepository.deleteByName(name);
    }

    @Override
    public List<RoleResponse> getAllRole() {
        return roleRepository.findAll().stream().map(RoleMapper::toRoleResponse).toList();
    }
}
