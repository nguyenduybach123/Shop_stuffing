package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.request.RoleRequest;
import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.dto.response.RoleResponse;
import com.backend.shopstuffing.service.impl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private RoleServiceImpl roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(roleService.createRole(request))
                .build();
    }

    @DeleteMapping("/{name}")
    ApiResponse<Void> delete(@PathVariable String name) {
        roleService.deleteRole(name);
        return ApiResponse.<Void>builder()
                .status(HttpStatus.OK.toString())
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .status(HttpStatus.OK.toString())
                .data(roleService.getAllRole())
                .build();
    }
}
