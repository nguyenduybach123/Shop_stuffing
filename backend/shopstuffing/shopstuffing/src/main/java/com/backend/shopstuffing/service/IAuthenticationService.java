package com.backend.shopstuffing.service;

import com.backend.shopstuffing.dto.request.AuthenticationRequest;
import com.backend.shopstuffing.dto.request.IntrospectRequest;
import com.backend.shopstuffing.dto.request.LogoutRequest;
import com.backend.shopstuffing.dto.request.RefreshRequest;
import com.backend.shopstuffing.dto.response.AuthenticationResponse;
import com.backend.shopstuffing.dto.response.IntrospectResponse;
import com.backend.shopstuffing.model.User;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;

public interface IAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    AuthenticationResponse refreshToken(RefreshRequest request) throws JOSEException, ParseException;
    void logout(LogoutRequest request) throws ParseException, JOSEException;
    String generateToken(User user);
    IntrospectResponse introspect(IntrospectRequest request)  throws JOSEException, ParseException;
    SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException;
}
