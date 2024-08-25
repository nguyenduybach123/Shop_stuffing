package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.request.PermissionRequest;
import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.dto.response.PermissionResponse;
import com.backend.shopstuffing.service.impl.PermissionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@AllArgsConstructor
public class PermissionController {

    private PermissionServiceImpl permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(permissionService.createPermission(request))
                .build();
    }

    @DeleteMapping("/{name}")
    ApiResponse<Void> delete(@PathVariable String name) {
        permissionService.deletePermission(name);
        return ApiResponse.<Void>builder()
                .status(HttpStatus.OK.toString())
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .status(HttpStatus.OK.toString())
                .data(permissionService.getAllPermission())
                .build();
    }
}
