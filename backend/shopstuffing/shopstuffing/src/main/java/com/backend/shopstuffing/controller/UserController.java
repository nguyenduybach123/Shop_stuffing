package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.request.UserCreateRequest;
import com.backend.shopstuffing.dto.request.UserUpdateRequest;
import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody UserCreateRequest request) {
        UserResponse userResponse = userService.createUser(request);

        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(userResponse)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ApiResponse.<String>builder()
                .status(HttpStatus.CREATED.toString())
                .data("User has been deleted")
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
        UserResponse userResponse = userService.updateUser(id, request);

        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(userResponse)
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUser() {
        return ApiResponse.<List<UserResponse>>builder()
                .status(HttpStatus.CREATED.toString())
                .data(userService.getAllUser())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable String id) {
        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(userService.getUser(id))
                .build();
    }

    @GetMapping("/profile")
    public ApiResponse<UserResponse> getUserProfile() {
        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(userService.getUserProfile())
                .build();
    }

}
