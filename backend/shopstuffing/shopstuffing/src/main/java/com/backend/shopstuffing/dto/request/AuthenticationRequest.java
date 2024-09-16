package com.backend.shopstuffing.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
public class AuthenticationRequest {
    @NotNull
    @NotBlank
    @Min(value = 8, message = "Least 8 char")
    private String username;

    @NotNull
    @NotBlank
    @Min(value = 8, message = "Least 8 char")
    private String password;
}
