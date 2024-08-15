package com.backend.shopstuffing.exception;

import com.backend.shopstuffing.dto.response.AuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthenticationErrorResponse extends ErrorResponse{
    public static final ErrorResponse UNAUTHENTICATED = new AuthenticationErrorResponse("Unauthenticated");
    public static final ErrorResponse UNAUTHENTICATION = new AuthenticationErrorResponse("Cann't create token");
    private int timeError;

    public AuthenticationErrorResponse(String message) {
        super(message);
    }

    public AuthenticationErrorResponse(String message, int timeError) {
        super(message);
        this.timeError = timeError;
    }
}
