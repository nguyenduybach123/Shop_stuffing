package com.backend.shopstuffing.controller;

import com.backend.shopstuffing.dto.request.*;
import com.backend.shopstuffing.dto.response.ApiResponse;
import com.backend.shopstuffing.dto.response.AuthenticationResponse;
import com.backend.shopstuffing.dto.response.IntrospectResponse;
import com.backend.shopstuffing.dto.response.UserResponse;
import com.backend.shopstuffing.service.impl.AuthenticationServiceImpl;
import com.backend.shopstuffing.service.impl.UserDetailServiceImpl;
import com.nimbusds.jose.JOSEException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;
    private final UserDetailServiceImpl userDetailService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .status(HttpStatus.OK.toString())
                .data(result)
                .build();
    }

    @PostMapping("/register")
    public ApiResponse<UserResponse> register(@RequestBody UserCreateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.toString())
                .data(userDetailService.signUpUser(request))
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .status(HttpStatus.OK.toString())
                .data(result)
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .status(HttpStatus.OK.toString())
                .data(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .status(HttpStatus.OK.toString())
                .build();
    }
}
