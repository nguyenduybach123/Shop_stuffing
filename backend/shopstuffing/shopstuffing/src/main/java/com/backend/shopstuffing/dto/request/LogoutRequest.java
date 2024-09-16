package com.backend.shopstuffing.dto.request;

import lombok.*;

@Getter
@Builder
public class LogoutRequest {
    private String token;
}
