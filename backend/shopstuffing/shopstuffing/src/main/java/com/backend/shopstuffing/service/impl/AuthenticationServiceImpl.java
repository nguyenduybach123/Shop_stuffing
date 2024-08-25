package com.backend.shopstuffing.service.impl;

import com.backend.shopstuffing.dto.request.AuthenticationRequest;
import com.backend.shopstuffing.dto.request.IntrospectRequest;
import com.backend.shopstuffing.dto.request.LogoutRequest;
import com.backend.shopstuffing.dto.request.RefreshRequest;
import com.backend.shopstuffing.dto.response.AuthenticationResponse;
import com.backend.shopstuffing.dto.response.IntrospectResponse;
import com.backend.shopstuffing.exception.ApplicationException;
import com.backend.shopstuffing.exception.AuthenticationErrorResponse;
import com.backend.shopstuffing.model.InvalidatedToken;
import com.backend.shopstuffing.model.User;
import com.backend.shopstuffing.repository.IInvalidatedTokenRepository;
import com.backend.shopstuffing.repository.IUserRepository;
import com.backend.shopstuffing.service.IAuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Value("${jwt.signerKey}")
    private String SIGNER_KEY;

    @Value("${jwt.valid-duration}")
    protected long VALID_DURATION;

    @Value("${jwt.refreshable-duration}")
    protected long REFRESHABLE_DURATION;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IInvalidatedTokenRepository invalidatedTokenRepository;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ApplicationException(AuthenticationErrorResponse.UNAUTHENTICATED, HttpStatus.UNAUTHORIZED));

        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!authenticated) {
            throw new ApplicationException(AuthenticationErrorResponse.UNAUTHENTICATED, HttpStatus.UNAUTHORIZED);
        }
        return AuthenticationResponse.builder()
                .token(generateToken(user))
                .build();
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) throws JOSEException, ParseException {
        SignedJWT signToken = verifyToken(request.getToken(), true);

        String jit = signToken.getJWTClaimsSet().getJWTID();
        Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jit)
                .expiryTime(expiryTime)
                .build();

        String username = signToken.getJWTClaimsSet().getSubject();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ApplicationException(AuthenticationErrorResponse.UNAUTHENTICATED, HttpStatus.UNAUTHORIZED));

        String token = generateToken(user);
        invalidatedTokenRepository.save(invalidatedToken);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public void logout(LogoutRequest request) throws ParseException, JOSEException {
        SignedJWT signToken = verifyToken(request.getToken(), true);

        String jit = signToken.getJWTClaimsSet().getJWTID();
        Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jit)
                .expiryTime(expiryTime)
                .build();

        invalidatedTokenRepository.save(invalidatedToken);
    }

    @Override
    public String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("shopstuffingserver.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", buildScope(user))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header,payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new ApplicationException(AuthenticationErrorResponse.UNAUTHENTICATION, HttpStatus.UNAUTHORIZED);
        }
    }

    private String buildScope(User user) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        if(!CollectionUtils.isEmpty(user.getRoles())) {
            user.getRoles().forEach(stringJoiner::add);
        }

        return stringJoiner.toString();
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        String token = request.getToken();
        boolean isValid = true;

        try{
            verifyToken(token, false);
        }
        catch (Exception ex) {
            isValid = false;
        }

        return IntrospectResponse.builder()
                .valid(isValid)
                .build();
    }

    @Override
    public SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = (isRefresh)
                ? new Date(signedJWT
                    .getJWTClaimsSet()
                    .getIssueTime()
                    .toInstant()
                    .plus(REFRESHABLE_DURATION, ChronoUnit.SECONDS)
                    .toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        boolean verified = signedJWT.verify(verifier);

        if (!(verified && expiryTime.after(new Date())))
            throw new ApplicationException(AuthenticationErrorResponse.UNAUTHENTICATED, HttpStatus.UNAUTHORIZED);

        if (invalidatedTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID()))
            throw new ApplicationException(AuthenticationErrorResponse.UNAUTHENTICATED, HttpStatus.UNAUTHORIZED);

        return signedJWT;
    }
}
